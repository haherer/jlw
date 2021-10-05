package com.nicholas.mapper;

import com.nicholas.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface StudentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    Student selectByName(String name);

    List<Student> selectAll();

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}