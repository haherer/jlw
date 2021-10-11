package com.nicholas.service;

import com.nicholas.domain.Comment;
import com.nicholas.vo.Result;
import com.nicholas.vo.parms.CommentRelease;
import com.nicholas.vo.parms.Page;

import java.util.List;

public interface CommentService {
    Result addComment(String token, CommentRelease commentRelease);

    List<Comment> findList(String token, String dataUid , Page page);
}
