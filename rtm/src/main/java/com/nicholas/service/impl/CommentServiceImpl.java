package com.nicholas.service.impl;

import com.github.pagehelper.PageHelper;
import com.nicholas.domain.Comment;
import com.nicholas.domain.Data;
import com.nicholas.mapper.CommentMapper;
import com.nicholas.mapper.DataMapper;
import com.nicholas.service.CommentService;
import com.nicholas.service.UserService;
import com.nicholas.utils.JWTUtils;
import com.nicholas.utils.RedisUtils;
import com.nicholas.vo.Enum.RedisKey;
import com.nicholas.vo.Result;
import com.nicholas.vo.parms.CommentRelease;
import com.nicholas.vo.parms.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private UserService userService;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private DataMapper dataMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    @Transactional
    public Result addComment(String token, CommentRelease commentRelease) {

        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        String account = (String) redisUtils.hget(RedisKey.TOKEN_KEY.getKey(), token);
        if (null == stringObjectMap || null == account){
            log.info("token失效");
            return null;
        }
        log.info("缓存中得到account:" + account);

        Long userId = (Long) stringObjectMap.get("userId");
        log.info("从token中获取对应UID为：" + userId);

        if(!userId.equals(commentRelease.getUid())){
            log.info("token中ID与发布者ID不一致" + "tokenId:" + userId + "发布者ID：" + commentRelease.getUid() );
            return null;
        }

        if(null == redisUtils.hmget(account)){
            log.info("发布者用户信息未找到");
            return null;
        }

//        Data data = dataMapper.selectByUid(commentRelease.getDataUid());
        if(!redisUtils.hasKey(commentRelease.getDataUid())){
            log.info("主数据信息未找到");
            return null;
        }

//        data.setCommentSum(data.getCommentSum() + 1); 数据库更新评论数量
//        dataMapper.updateByPrimaryKeySelective(data);
        double commentSum = redisUtils.hincr(commentRelease.getDataUid(), "commentSum", 1);
        log.info("缓存中dataUid字段commentSum++后结果:" + + commentSum);

        Comment comment = new Comment();
        comment.setDataUid(commentRelease.getDataUid());
        comment.setUid(userId);
        comment.setContent(commentRelease.getContent());
        comment.setCreationTime(new Date());
        log.info("赋值完成");
        if(commentMapper.insertSelective(comment) > 0){
            log.info("评论发布成功");
            return Result.success(null);
        }
        return null;
    }

    @Override
    public List<Comment> findList(String token, String dataUid , Page page) {

        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        String account = (String) redisUtils.hget(RedisKey.TOKEN_KEY.getKey(), token);
        if (null == stringObjectMap || null == account){
            log.info("token失效");
            return null;
        }
        log.info("缓存中得到account:" + account);

        PageHelper.startPage(page.getPageNum(),page.getPageSize());//分页
        List<Comment> comments = commentMapper.selectAllByDataUid(dataUid);
        if (null == comments) {
            log.info("未查询到数据");
            return null;
        }
        return comments;
    }
}
