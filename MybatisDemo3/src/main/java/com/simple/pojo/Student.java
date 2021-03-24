package com.simple.pojo;

import lombok.Data;

/**
 * @author Simple
 * @data 2021/3/23 22:33
 * 多个学生，对应一个老师：多对一
 */
@Data
public class Student {
    private int id;
    private String name;
    private int  tid;
}
