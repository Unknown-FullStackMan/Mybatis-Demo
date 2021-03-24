package com.simple.DaoTest;


import com.simple.utils.MybatisUtils;
import com.simple.mapper.UserMapper;
import com.simple.pojo.User;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void test(){
        SqlSession sqlsession = MybatisUtils.getSession();

        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }
//        关闭
        sqlsession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    // 增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.addUser(new User(4, "皮卡丘", "123456789"));
        if(res > 0){
            System.out.println("插入成功");
        }
        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(4,"yzs","0000"));
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userid",7);
        map.put("name","simple");
        map.put("password","123321");
        mapper.addUser2(map);

        Assert.assertNotNull(map);

        sqlSession.rollback();
        sqlSession.close();
    }

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("%李%");
        System.out.println(userList);
        sqlSession.close();
    }

    @Test
    public void TestLog4j(){
        logger.info("info:进入了testLog4j");
        logger.debug("DEBUG:进入了testLog4j");
        logger.error("erro:进入了testLog4j");
    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",2);
        map.put("pageSize",2);

        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSession();

        //RowBounds实现
        RowBounds rowBounds = new RowBounds(0, 2);

        //通过java代码层面实现分页
        List<User> userList = sqlSession.selectList("com.simple.mapper.UserMapper.getUserByRowBounds",null,rowBounds);

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUsers(){
        SqlSession sqlSession = MybatisUtils.getSession();

        //本质：反射机制实现
        //底层：动态代理！
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }



}

