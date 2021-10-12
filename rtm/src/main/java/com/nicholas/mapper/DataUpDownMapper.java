package com.nicholas.mapper;

import com.nicholas.domain.DataUpDown;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DataUpDownMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DataUpDown record);

    int insertSelective(DataUpDown record);

    DataUpDown selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataUpDown record);

    int updateByPrimaryKey(DataUpDown record);
}