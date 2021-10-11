package com.nicholas.service.impl;

import com.github.pagehelper.PageHelper;
import com.nicholas.domain.Comment;
import com.nicholas.mapper.CommentMapper;
import com.nicholas.mapper.DataMapper;
import com.nicholas.service.CommentService;
import com.nicholas.service.UserService;
import com.nicholas.utils.JWTUtils;
import com.nicholas.vo.Result;
import com.nicholas.vo.parms.CommentRelease;
import com.nicholas.vo.parms.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Result addComment(String token, CommentRelease commentRelease) {

        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        if (null == stringObjectMap){
            log.info("token失效");
            return null;
        }

        Integer userId = (Integer) stringObjectMap.get("userId");
        log.info("从token中获取对应UID为：" + userId);

        if(!userId.equals(commentRelease.getUid())){
            log.info("token中ID与发布者ID不一致" + "tokenId:" + userId + "发布者ID：" + commentRelease.getUid() );
            return null;
        }

        if(null == userService.findUid(userId)){
            log.info("发布者用户信息未找到");
            return null;
        }
//        Data data = dataMapper.selectByUid(commentRelease.getDataUid());
//        log.info(data.toString());

        if(null == dataMapper.selectByUid(commentRelease.getDataUid())){
            log.info("主数据信息未找到");
            return null;
        }

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
        if (null == stringObjectMap){
            log.info("token失效");
            return null;
        }
        PageHelper.startPage(page.getPageNum(),page.getPageSize());//分页
        List<Comment> comments = commentMapper.selectAllByDataUid(dataUid);
        if (null == comments) {
            log.info("未查询到数据");
            return null;
        }
        return comments;
    }
}
