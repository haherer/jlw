package com.nicholas.controller;

import com.nicholas.domain.Comment;
import com.nicholas.service.CommentService;
import com.nicholas.vo.Enum.ErrorCode;
import com.nicholas.vo.Result;
import com.nicholas.vo.parms.CommentRelease;
import com.nicholas.vo.parms.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/release")
    public Result releaseComment(@RequestHeader("token") String token , CommentRelease commentRelease){

        if (null == commentRelease){
            log.info("提交数据不能为空");
            return Result.fail(ErrorCode.DATA_NULL.getCode(), ErrorCode.DATA_NULL.getMsg());
        }

        if (null == commentRelease.getContent() || null == commentRelease.getDataUid()
            || null == commentRelease.getUid()){
            log.info("提交内容/数据编号/提交者UID不能为空");
            return  Result.fail(ErrorCode.DATA_NULL.getCode(), ErrorCode.DATA_NULL.getMsg());
        }

        Result result = commentService.addComment(token, commentRelease);

        if(null == result){
            return  Result.fail(ErrorCode.DATA_NULL.getCode(), ErrorCode.DATA_NULL.getMsg());
        }

        return result;
    }

    @GetMapping("/commentList")
    public Result queryComment(@RequestHeader("token") String token , String dataUid , Page page){

        if (null == dataUid || null == page){
            log.info("提交数据不能为空");
            return Result.fail(ErrorCode.DATA_NULL.getCode(), ErrorCode.DATA_NULL.getMsg());
        }

        List<Comment> list = commentService.findList(token, dataUid, page);
        if (null == list){
            log.info("token失效，或没有数据");
            return Result.fail(ErrorCode.DATA_NULL.getCode(), ErrorCode.DATA_NULL.getMsg());
        }

        log.info("查询成功" + list.toString());
        return Result.success(list);
    }
}
