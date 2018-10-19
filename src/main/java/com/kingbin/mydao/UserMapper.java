package com.kingbin.mydao;

import com.kingbin.bean.UserBean;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by WangBin on 2018/10/19
 */
public interface UserMapper {

    /*******查询所有用户数据********/
    @Select("select * from user")
    public List<UserBean> findUserByAll();

    /*******根据Id查询符合用户********/
    @Select("select * from user where id=#{userId}")
    public UserBean findUserById(Long userId);

    /*******根据name查询符合用户********/
    @Select("select * from user where username=#{name}")
    public List<UserBean> findUserByName(String name);

    /*******添加新用户********/
    @Select("insert into user(username,password,age) values (#{username},#{password},#{age})")
    public int addUser(UserBean user);

    /*******修改已有用户信息********/
    @Update("update user set username=#{username},age=#{age},password=#{password} where id=#{id}")
    public int updateUser(UserBean user);

    /*******根据id删除用户********/
    @Select("delete from user where id = #{userId}")
    public int deleteUserById(Long userId);
}
