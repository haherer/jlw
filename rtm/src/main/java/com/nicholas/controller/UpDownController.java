package com.nicholas.controller;


import com.nicholas.service.QueryService;
import com.nicholas.service.UpDownService;
import com.nicholas.vo.ErrorCode;
import com.nicholas.vo.Result;
import com.nicholas.vo.UserQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/upDown")
public class UpDownController {

    @Autowired
    private UpDownService upDownService;

    @Autowired
    private QueryService queryService;

    @PostMapping("/up")
    public Result up(@RequestHeader("token") String token , String dataUid){

        log.info("获取token：" + token);
        UserQueryVo userQueryVo = queryService.queryUserByToken(token);
        if (null == userQueryVo){
            log.info("token失效，未找到信息");
            return Result.fail(ErrorCode.TOKEN_FAIL.getCode(), ErrorCode.TOKEN_FAIL.getMsg());
        }
        if(null == dataUid){
            log.info("提交数据不可为空");
            return Result.fail(ErrorCode.RELEASE_NULL.getCode(), ErrorCode.RELEASE_NULL.getMsg());
        }

        Integer integer = upDownService.doUp(dataUid);
        if (null == integer || integer <= 0){
            return Result.fail(ErrorCode.SYSTEM_ERROR.getCode(), ErrorCode.SYSTEM_ERROR.getMsg());
        }
        return Result.success(integer);
    }

    @PostMapping("/down")
    public Result down(@RequestHeader("token") String token , String dataUid){

        log.info("获取token：" + token);
        UserQueryVo userQueryVo = queryService.queryUserByToken(token);
        if (null == userQueryVo){
            log.info("token失效，未找到信息");
            return Result.fail(ErrorCode.TOKEN_FAIL.getCode(), ErrorCode.TOKEN_FAIL.getMsg());
        }
        if(null == dataUid){
            log.info("提交数据不可为空");
            return Result.fail(ErrorCode.RELEASE_NULL.getCode(), ErrorCode.RELEASE_NULL.getMsg());
        }
        Integer integer = upDownService.doDown(dataUid);
        if (null == integer || integer <= 0){
            return Result.fail(ErrorCode.SYSTEM_ERROR.getCode(), ErrorCode.SYSTEM_ERROR.getMsg());
        }
        return Result.success(integer);
    }
}
