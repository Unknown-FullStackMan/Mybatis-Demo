package com.simple.mapper;

import com.simple.pojo.Student;

import java.util.List;

/**
 * @author Simple
 * @data 2021/3/23 22:38
 */
public interface StudentMapper {

    //查询所有学生的信息，以及对于老师的信息
     List<Student> getStudent();

     List<Student> getStudent2();
}
