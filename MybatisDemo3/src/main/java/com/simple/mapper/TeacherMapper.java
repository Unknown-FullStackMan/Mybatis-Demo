package com.simple.mapper;

import com.simple.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Simple
 * @data 2021/3/23 22:39
 */

public interface TeacherMapper {


    //一个老师拥有多个学生
   Teacher getTeacher(@Param("tid") int id);

    Teacher getTeacher2(@Param("tid") int id);

}
