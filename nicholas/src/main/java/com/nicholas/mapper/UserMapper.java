package com.nicholas.mapper;

import com.nicholas.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByAccount(String account);

//    User selectPassWord(String account);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}