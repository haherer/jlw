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

    User selectByPrimaryAccount(String account);

    User selectByPrimaryPhone(Integer phone);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}