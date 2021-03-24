package com.simple.mapper;

import com.simple.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


public interface UserMapper {

    /**
     * xml开发
     * @return 0
     */

    // 查询全部用户
    List<User> getUserList();

    // 根据ID查询用户
    User getUserById(int id);

    //插入一个用户
    int addUser(User user);

    // 修改用户
    int updateUser(User user);

    // 删除用户
    int deleteUser(int id);

    //万能的Map
    int addUser2(Map<String,Object> map);

    //模糊查询
    List<User> getUserLike(String name);

    //使用Limit分页
    List<User> getUserByLimit(Map<String,Integer> map);

    //使用RowBounds分页
    List<User> getUserByRowBounds();


    /**
     * 注解开发
     * @return 0
     */
    @Select("select * from user")
    List<User> getUsers();

    //方法存在多个参数，所有参数前面必须加上@Param("id")注解
    @Select("select * from user where id=#{id}")
    User getUserById02(@Param("id") int id);

    @Insert("insert into user (id,name,pwd) values(#{id},#{name},#{password})")
    int addUser02(User user);

    @Update("update user set name=#{name},pwd=#{password} where id=#{id}")
    int updateUser02(User user);

    @Delete("delete from user where id = #{uid}")
    int deleteUser02(@Param("uid") int id);


}