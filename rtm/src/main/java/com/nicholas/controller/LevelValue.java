package com.nicholas.controller;


import com.nicholas.service.QueryService;
import com.nicholas.service.impl.LevelValueImpl;
import com.nicholas.service.impl.UserServiceImpl;
import com.nicholas.utils.RedisUtils;
import com.nicholas.vo.Enum.ErrorCode;
import com.nicholas.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/levelValue")
public class LevelValue {

    @Autowired
    private LevelValueImpl levelValue;

    @Autowired
    private QueryService queryService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RedisUtils redisUtils;

    //扣除经验值
    @PostMapping("/sub")
    public Result subLevelValue(@RequestHeader("token")String token , String account , Long value){
        log.info("获取token：" + token);
        Object obj = queryService.queryUserByToken(token);

        if (null == obj){
            log.info("token失效，未找到信息");
            return Result.fail(ErrorCode.TOKEN_FAIL.getCode(), ErrorCode.TOKEN_FAIL.getMsg());
        }

        if (!redisUtils.hasKey(account)){
            log.info("操作用户不存在");
            return Result.fail(ErrorCode.NOT_ACCOUNT.getCode(), ErrorCode.NOT_ACCOUNT.getMsg());
        }

        if (null == value || value <= 0){
            log.info("操作值不能为空");
            return Result.fail(ErrorCode.NOT_VALUE.getCode(), ErrorCode.NOT_ACCOUNT.getMsg());
        }

        log.info("信息获取成功" + obj);
        if (levelValue.subValue(account, value)){
            return Result.success(null);
        }
        return Result.fail(ErrorCode.SYSTEM_ERROR.getCode(), ErrorCode.SYSTEM_ERROR.getMsg());
    }
}
