package com.kingbin.mapper;

import com.kingbin.model.UserBean;
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
    List<UserBean> findUserByAll();

    /*******根据Id查询符合用户********/
    UserBean findUserById(Long userId);

    /*******根据name查询符合用户********/
    List<UserBean> findUserByName(String userName);

    /*******根据name包含此字段查询符合用户********/
    List<UserBean> findUserLikeName(String userName);

    /*******根据name和age查询符合用户********/
    List<UserBean> findUserByUser(UserBean user);

    /*******添加新用户********/
    int addUser(UserBean user);

    /*******修改已有用户信息********/
    int updateUser(UserBean user);

    /*******根据id删除用户********/
    int deleteUserById(Long userId);

    /*******根据名字删除用户********/
    int deleteUserByName(String userName);

    /*******根据名字是否包含字段删除用户********/
    int deleteUserLikeName(String userName);
}
