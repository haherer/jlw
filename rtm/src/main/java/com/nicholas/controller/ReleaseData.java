package com.nicholas.controller;

import com.nicholas.service.DataService;
import com.nicholas.service.QueryService;
import com.nicholas.vo.ErrorCode;
import com.nicholas.vo.Result;
import com.nicholas.vo.UserQueryVo;
import com.nicholas.vo.parms.Release;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/release")
public class ReleaseData {
    @Autowired
    private QueryService queryService;

    @Autowired
    private DataService dataService;

    @PostMapping("/data")
    public Result releaseData(@RequestHeader("token")String token , Release release){
        log.info("获取token：" + token);
        UserQueryVo userQueryVo = queryService.queryUserByToken(token);
        if (null == userQueryVo){
            log.info("token失效，未找到信息");
            return Result.fail(ErrorCode.TOKEN_FAIL.getCode(), ErrorCode.TOKEN_FAIL.getMsg());
        }
        if(null == release.getLongitude() || null == release.getLatitude() ||
           null == release.getPoi() || null == release.getContent()){
            log.info("提交数据不可为空");
            return Result.fail(ErrorCode.RELEASE_NULL.getCode(), ErrorCode.RELEASE_NULL.getMsg());
        }
        Integer i = dataService.addData(release , userQueryVo);
        if (null == i || i <= 0){
            log.info("发布失败");
            return Result.fail(ErrorCode.RELEASE_FAIL.getCode(), ErrorCode.RELEASE_FAIL.getMsg());
        }
        log.info("发布成功");
        return Result.success(i);

    }
}
