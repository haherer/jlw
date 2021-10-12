package com.nicholas.controller;

import com.nicholas.service.DataServiceFromRedis;
import com.nicholas.service.QueryService;
import com.nicholas.vo.DataVo;
import com.nicholas.vo.Enum.ErrorCode;
import com.nicholas.vo.Result;
import com.nicholas.vo.UserQueryVo;
import com.nicholas.vo.parms.NearDataList;
import com.nicholas.vo.parms.Page;
import com.nicholas.vo.redis.DataPosition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/query")
public class QueryController {
    @Autowired
    private QueryService queryService;

    @Autowired
    private DataServiceFromRedis dataServiceFromRedis;

    @GetMapping("/user")
    public Result queryUser(@RequestHeader("token") String token){
        log.info("获取token：" + token);
        Object obj = queryService.queryUserByToken(token);
        if (null == obj){
            log.info("token失效，未找到信息");
            return Result.fail(ErrorCode.TOKEN_FAIL.getCode(), ErrorCode.TOKEN_FAIL.getMsg());
        }
        log.info("信息获取成功" + obj);
        return Result.success(obj);
    }

    @GetMapping("/data")
    public Result queryAllData(Page page){
        if (page.getPageSize() > 20){
            page.setPageSize(20);
        }
        List<DataVo> dataVo = queryService.queryAllData(page.getPageNum(),page.getPageSize());
        if (dataVo.isEmpty()){
            log.info("没有数据");
            return Result.fail(ErrorCode.DATA_NULL.getCode(), ErrorCode.DATA_NULL.getMsg());
        }
        log.info("数据获取成功" + dataVo);
        return Result.success(dataVo);
    }

    /**
     * 通过redis查询附近数据
     * */
    @GetMapping("/newData")
    public Result queryAllByRedis(@RequestHeader("token") String token , NearDataList nearDataList){
        if (null == nearDataList.getNear() || null == nearDataList.getLat()
        || null == nearDataList.getLng() || null == nearDataList.getCityId()
        || null == nearDataList.getPageSize() || null == nearDataList.getPageNum()){
            return Result.fail(ErrorCode.DATA_VALUE_NULL.getCode(), ErrorCode.DATA_VALUE_NULL.getMsg());
        }

        List<DataPosition> dataPositions = dataServiceFromRedis.nearDataList(nearDataList);

        return Result.success(dataPositions);
    }
}
