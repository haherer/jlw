package com.nicholas.mapper;

import com.nicholas.domain.Level;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LevelMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Level record);

    int insertSelective(Level record);

    Level selectByPrimaryKey(Integer id);

    Level selectByPrimaryLevelId(Integer levelId);

    int updateByPrimaryKeySelective(Level record);

    int updateByPrimaryKey(Level record);
}