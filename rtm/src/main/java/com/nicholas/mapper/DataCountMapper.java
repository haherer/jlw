package com.nicholas.mapper;

import com.nicholas.domain.DataCount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DataCountMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DataCount record);

    int insertSelective(DataCount record);

    DataCount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataCount record);

    int updateByPrimaryKey(DataCount record);
}