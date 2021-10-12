package com.nicholas.service.impl;

import com.github.pagehelper.PageHelper;
import com.nicholas.domain.Data;
import com.nicholas.domain.Level;
import com.nicholas.domain.User;
import com.nicholas.mapper.DataMapper;
import com.nicholas.mapper.LevelMapper;
import com.nicholas.service.QueryService;
import com.nicholas.utils.JWTUtils;
import com.nicholas.utils.RedisUtils;
import com.nicholas.vo.DataVo;
import com.nicholas.vo.Enum.RedisKey;
import com.nicholas.vo.UserQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class QueryServiceImpl implements QueryService {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private LevelMapper levelMapper;

    @Autowired
    private DataMapper dataMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Object queryUserByToken(String token) {

        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        String account = (String) redisUtils.hget(RedisKey.TOKEN_KEY.getKey(), token);
        if (null == stringObjectMap || null == account){
            log.info("token失效");
            return null;
        }
        log.info("缓存中得到account:" + account);
        return redisUtils.hmget(account);
    }

    @Override
    public Level queryLevelByLevelId(Integer levelId) {
        Level level = levelMapper.selectByPrimaryLevelId(levelId);
        if (null == level){
            log.info("等级信息未找到");
            return null;
        }
        return level;
    }

    @Override
    public List<DataVo> queryAllData(Integer pageNum , Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);//分页
        List<Data> datas = dataMapper.selectAllData();
        if (null != datas){
            ArrayList<DataVo> dataVos = new ArrayList<>();
            log.info("获取数据，开始遍历");
            for (Data data: datas) {
                DataVo dataVo = new DataVo();
                dataVo.setUid(data.getUid());
                dataVo.setCreationTime(data.getCreationTime());
                dataVo.setLongitude(BigDecimal.valueOf(data.getLongitude()));
                dataVo.setLatitude(BigDecimal.valueOf(data.getLatitude()));
                dataVo.setPoi(data.getPoi());
                dataVo.setContent(data.getContent());
                dataVo.setImgUrl(data.getImgUrl());
                dataVo.setVideoUrl(data.getVideoUrl());
                dataVo.setHotValue(data.getHotValue());
                dataVo.setDataUid(data.getDataUid());
                dataVo.setAccuracy(data.getAccuracy());
                dataVo.setTrueSum(data.getTrueSum());
                dataVo.setFalseSum(data.getFalseSum());
                dataVo.setCommentSum(data.getCommentSum());
                dataVos.add(dataVo);
            }
            log.info("遍历完成");
            return dataVos;
        }
        return null;
    }
}
