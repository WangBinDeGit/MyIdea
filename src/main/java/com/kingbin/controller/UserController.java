package com.kingbin.controller;

import com.kingbin.model.ResultModel;
import com.kingbin.model.UserBean;
import com.kingbin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WangBin  on 2018/4/11.
 * <p>
 * 操作用户表接口
 */
@RestController
@RequestMapping(value = "/user")
@Api(description = "用户操作")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询所有用户")
    @RequestMapping(value = "/findUserByAll", method = RequestMethod.POST)
    public ResultModel findUserByAll() {
        return userService.findUserByAll();
    }

    @ApiOperation(value = "查找用户")
    @RequestMapping(value = "/findUserById", method = RequestMethod.POST)
    public ResultModel findUserById(@RequestParam(value = "userId") Long userId) {
        return userService.findUserById(userId);
    }

    @ApiOperation(value = "查找用户")
    @RequestMapping(value = "/findUserByName", method = RequestMethod.POST)
    public ResultModel findUserByName(@RequestParam(value = "userName") String userName, String type) {
        return userService.findUserByName(userName, type);
    }

    @ApiOperation(value = "查找用户")
    @RequestMapping(value = "/findUserByUser", method = RequestMethod.POST)
    public ResultModel findUserByUser(String userName, String passWord, Integer age) {
        return userService.findUserByUser(userName, passWord, age);
    }

    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResultModel addUser(@RequestParam(value = "userName") String userName, String passWord, Integer userAge) {
        return userService.addUser(userName, passWord, userAge);
    }

    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/addUsers", method = RequestMethod.POST)
    public ResultModel addUsers(UserBean user) {
        return userService.addUsers(user);
    }

    @ApiOperation(value = "修改用户")
    @RequestMapping(value = "/upDataUserById", method = RequestMethod.POST)
    public ResultModel upDataUserById(@RequestParam(value = "userId") Long userId, String userName, String passWord, Integer userAge) {
        return userService.upDataUserById(userId, userName, passWord, userAge);
    }

    @ApiOperation(value = "修改用户")
    @RequestMapping(value = "/upDataUserByUser", method = RequestMethod.POST)
    public ResultModel upDataUserByUser(UserBean user) {
        return userService.upDataUserByUser(user);
    }

    @ApiOperation(value = "根据userId删除用户")
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.POST)
    public ResultModel deleteUserById(@RequestParam(value = "userId") Long userId) {
        return userService.deleteUserById(userId);
    }

    @ApiOperation(value = "根据userName删除用户")
    @RequestMapping(value = "/deleteUserByName", method = RequestMethod.POST)
    public ResultModel deleteUserByName(@RequestParam(value = "userName") String userName, String type) {
        return userService.deleteUserByName(userName, type);
    }
}