package com.nicholas.mapper;

import com.nicholas.domain.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface DataMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Data record);

    int insertSelective(Data record);

    Data selectByPrimaryKey(Integer id);

    Data selectByUid(String id);

    List<Data> selectAllData();

    int updateByPrimaryKeySelective(Data record);

    int updateByPrimaryKey(Data record);
}