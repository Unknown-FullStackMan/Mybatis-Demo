package com.simple.mapper;

import com.simple.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author Simple
 * @data 2021/3/24 18:44
 */
public interface BlogMapper {

    //插入数据
    int addBlog(Blog blog);

    //查询数据
    List<Blog> queryBlogIF(Map map);

    //查询数据
    List<Blog> queryBlogChoose(Map map);

    //更新数据
    int updateBlog(Map map);

    //查询第1，2，3记录的博客
    List<Blog> queryBlogForeach(Map map);
}
