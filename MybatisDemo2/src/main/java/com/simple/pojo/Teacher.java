package com.simple.pojo;

import com.simple.mapper.TeacherMapper;
import com.simple.utils.MybatisUtils;
import lombok.Data;
import org.apache.ibatis.session.SqlSession;

/**
 * @author Simple
 * @data 2021/3/23 22:33
 * 一个老师拥有多个学生:一对多
 */

@Data
public class Teacher {
    private  int id;
    private String name;

}


