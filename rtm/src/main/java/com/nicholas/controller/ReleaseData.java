package com.nicholas.controller;

import com.nicholas.service.DataService;
import com.nicholas.service.QueryService;
import com.nicholas.utils.JWTUtils;
import com.nicholas.utils.RedisUtils;
import com.nicholas.vo.Enum.ErrorCode;
import com.nicholas.vo.Enum.RedisKey;
import com.nicholas.vo.Result;
import com.nicholas.vo.UserQueryVo;
import com.nicholas.vo.parms.Release;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/release")
public class ReleaseData {
    @Autowired
    private QueryService queryService;

    @Autowired
    private DataService dataService;

    @Autowired
    private RedisUtils redisUtils;

    @PostMapping("/data")
    public Result releaseData(@RequestHeader("token")String token , Release release){
        log.info("获取token：" + token);

        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        String account = (String) redisUtils.hget(RedisKey.TOKEN_KEY.getKey(), token);
        if (null == stringObjectMap || null == account){
            log.info("token失效");
            return null;
        }

        if(null == release.getLongitude() || null == release.getLatitude() ||
           null == release.getPoi() || null == release.getContent()){
            log.info("提交数据不可为空");
            return Result.fail(ErrorCode.RELEASE_NULL.getCode(), ErrorCode.RELEASE_NULL.getMsg());
        }

        Integer i = dataService.addData(release , account);
        if (null == i || i <= 0){
            log.info("发布失败");
            return Result.fail(ErrorCode.RELEASE_FAIL.getCode(), ErrorCode.RELEASE_FAIL.getMsg());
        }
        log.info("发布成功");
        return Result.success(i);

    }
}
