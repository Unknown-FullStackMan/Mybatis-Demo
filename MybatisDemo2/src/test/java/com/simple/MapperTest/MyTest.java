package com.simple.MapperTest;

/**
 * @author Simple
 * @data 2021/3/23 22:58
 */

import com.simple.mapper.StudentMapper;
import com.simple.pojo.Student;
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
    public void getStudent() {

        SqlSession sqlSession = MybatisUtils.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent();

        for (Student student : studentList){
            System.out.println(student);
        }
        sqlSession.close();
    }


    @Test
    public void getStudent2() {

        SqlSession sqlSession = MybatisUtils.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent2();

        for (Student student : studentList){
            System.out.println(student);
        }
        sqlSession.close();
    }


}