package com.simple.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Simple
 * @data 2021/3/24 18:42
 */

@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime; //属性名和字段名不一致
    private int views;
}
