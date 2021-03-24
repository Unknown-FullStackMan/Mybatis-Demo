package com.simple.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author Simple
 * @data 2021/3/23 22:33
 * 一个老师拥有多个学生:一对多
 */

@Data
public class Teacher {
    private  int id;
    private String name;

    //一个老师对多个学习
    private List<Student> students;
}


