package com.kingbin.service;

import com.kingbin.model.ResultModel;
import com.kingbin.model.UserBean;

/**
 * Created by WangBin on 2018/10/23
 */
public interface UserService {

    ResultModel findUserByAll();

    ResultModel findUserById(Long userId);

    ResultModel findUserByName(String userName, String type);

    ResultModel findUserByUser(String userName, String passWord, Integer age);

    ResultModel addUser(String userName, String passWord, Integer age);

    ResultModel addUsers(UserBean user);

    ResultModel upDataUserById(Long userId, String userName, String passWord, Integer userAge);

    ResultModel upDataUserByUser(UserBean user);

    ResultModel deleteUserById(Long userId);

    ResultModel deleteUserByName(String userName, String type);

}
