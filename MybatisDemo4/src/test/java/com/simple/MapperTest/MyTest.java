package com.simple.MapperTest;

/**
 * @author Simple
 * @data 2021/3/23 22:58
 */

import com.simple.mapper.BlogMapper;
import com.simple.pojo.Blog;
import com.simple.utils.IDutils;
import com.simple.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author Simple
 * @data 2021/3/23 22:51
 */
public class    MyTest {


    @Test
    public void addBlogTest() {
        SqlSession sqlSession = MybatisUtils.getSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务");
        mapper.addBlog(blog);

        sqlSession.rollback();
        sqlSession.close();


    }

    @Test
    public void queryBolgIFTest(){
        SqlSession sqlSession = MybatisUtils.getSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();

        //map.put("title","Java");
        map.put("author","狂神说");

        List<Blog> blogs = mapper.queryBlogIF(map);

        for (Blog blog : blogs){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogChooseTest(){
        SqlSession sqlSession = MybatisUtils.getSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title","Java");
        map.put("views","9999");

        List<Blog> blogs = mapper.queryBlogChoose(map);

        for (Blog blog : blogs){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updataBlogTest(){
        SqlSession sqlSession = MybatisUtils.getSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("id","67fa696e3b5347e185e610f6eade5138");
        map.put("title","Java2");
        map.put("views","9998");

       mapper.updateBlog(map);
        sqlSession.close();
    }

    @Test
    public void queryBlogForeachTest(){
        SqlSession sqlSession = MybatisUtils.getSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<String> ids =new ArrayList<String>();
        ids.add("67fa696e3b5347e185e610f6eade5138");

        map.put("ids",ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);

        for(Blog blog :blogs){
            System.out.println(blog);
        }
        sqlSession.close();
    }



}