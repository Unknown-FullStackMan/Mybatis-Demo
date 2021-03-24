package com.simple.MapperTest;

/**
 * @author Simple
 * @data 2021/3/23 22:58
 */

import com.simple.mapper.StudentMapper;
import com.simple.mapper.TeacherMapper;
import com.simple.pojo.Student;
import com.simple.pojo.Teacher;
import com.simple.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author Simple
 * @data 2021/3/23 22:51
 */
public class MyTest {


    @Test
    public void getTeacher() {

        SqlSession sqlSession = MybatisUtils.getSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher =  mapper.getTeacher(1);


            System.out.println(teacher);

        sqlSession.close();
    }


    @Test
    public void getTeacher2() {

        SqlSession sqlSession = MybatisUtils.getSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher =  mapper.getTeacher2(1);


        System.out.println(teacher);

        sqlSession.close();
    }


}