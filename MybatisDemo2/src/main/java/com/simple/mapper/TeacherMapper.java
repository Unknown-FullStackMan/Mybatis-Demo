package com.simple.mapper;

import com.simple.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Simple
 * @data 2021/3/23 22:39
 */

public interface TeacherMapper {

    @Select("select * from teacher where id= #{tid}")
    Teacher getTeacher(@Param("tid") int id);


}
