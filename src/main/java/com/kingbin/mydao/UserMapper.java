package com.kingbin.mydao;

import com.kingbin.bean.UserBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by WangBin on 2018/10/19
 */
@Repository
@Component
public interface UserMapper {

    /*******查询所有用户数据********/
    @Select("select * from user")
    List<UserBean> findUserByAll();

    /*******根据Id查询符合用户********/
    @Select("select * from user where id=#{userId}")
    UserBean findUserById(Long userId);

    /*******根据name查询符合用户********/
    @Select("select * from user where username=#{username}")
    List<UserBean> findUserByName(String username);

    /*******根据name包含此字段查询符合用户********/
    @Select("select * from user where username like concat('%', #{userName},'%')")
    List<UserBean> findUserLikeName(String username);

    /*******根据name和age查询符合用户********/
    List<UserBean> findUserByUser(UserBean user);

    /*******添加新用户********/
    @Insert("insert into user(username,password,age) values (#{username},#{password},#{age})")
    int addUser(UserBean user);

    /*******修改已有用户信息********/
//    @Update("update user set username=#{username},age=#{age},password=#{password} where id=#{id}")
    int updateUser(UserBean user);

    /*******根据id删除用户********/
    @Delete("delete from user where id = #{userId}")
    int deleteUserById(Long userId);

    /*******根据名字删除用户********/
    @Delete("delete from user where username = #{userName}")
    int deleteUserByName(String userName);

    /*******根据名字是否包含字段删除用户********/
    @Delete("delete from user where username like concat('%', #{userName},'%')")
    int deleteUserLikeName(String userName);
}
