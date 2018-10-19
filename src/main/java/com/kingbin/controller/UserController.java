package com.kingbin.controller;

import com.kingbin.ObjectUtils;
import com.kingbin.bean.ResultModel;
import com.kingbin.bean.ResultTools;
import com.kingbin.bean.UserBean;
import com.kingbin.mydao.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WangBin  on 2018/4/11.
 * <p>
 * 操作用户表接口
 */
@RestController
@RequestMapping(value = "/user")
@Api(description = "用户")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "查询所有用户")
    @RequestMapping(value = "/findUserByAll", method = RequestMethod.GET)
    public ResultModel findUserByAll() {
        try {
            Iterable<UserBean> users = userMapper.findUserByAll();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("content", users);
            return ResultTools.result(0, "", map);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @ApiOperation(value = "查找用户")
    @ApiImplicitParam(name = "id", value = "userId", paramType = "query", required = true, dataType = "Long")
    @RequestMapping(value = "/findUserById", method = RequestMethod.POST)
    public ResultModel findUserById(@RequestParam(value = "userId") Long userId) {
        try {
            if (ObjectUtils.isEmpty(userId))
                return ResultTools.result(1001, "", null);
            UserBean user = userMapper.findUserById(userId);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("content", user);
            return ResultTools.result(0, "", map);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @ApiOperation(value = "查找用户")
    @ApiImplicitParam(name = "username", value = "userName", paramType = "query", required = true)
    @RequestMapping(value = "/findUserByName", method = RequestMethod.POST)
    public ResultModel findUserByName(@RequestParam(value = "userName") String userName, String type) {
        try {
            if (ObjectUtils.isEmpty(userName))
                return ResultTools.result(1001, "", null);
            Iterable<UserBean> users;
            if ("like".equals(type)) users = userMapper.findUserLikeName(userName);
            else users = userMapper.findUserByName(userName);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("content", users);
            return ResultTools.result(0, "", map);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @ApiOperation(value = "添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "userName", paramType = "query", required = true),
            @ApiImplicitParam(name = "password", value = "passWord", paramType = "query", required = true),
            @ApiImplicitParam(name = "age", value = "age", paramType = "query", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResultModel addUser(@RequestParam(value = "userName") String userName, String passWord, Integer age) {
        try {
            UserBean user = new UserBean();
            user.setUsername(userName);
            user.setPassword(passWord);
            user.setAge(age);
            int code = userMapper.addUser(user);
            if (1 == code) return ResultTools.result(0, "添加成功", null);
            else return ResultTools.result(0, "添加失败", null);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/addUsers", method = RequestMethod.POST)
    public ResultModel addUsers(UserBean user) {
        try {
            if (ObjectUtils.isEmpty(user) || ObjectUtils.isEmpty(user.getUsername()))
                ResultTools.result(1001, "", null);
            int code = userMapper.addUser(user);
            if (1 == code) return ResultTools.result(0, "添加成功", null);
            else return ResultTools.result(0, "添加失败", null);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @ApiOperation(value = "修改用户")
    @RequestMapping(value = "/upDataUserById", method = RequestMethod.POST)
    public ResultModel upDataUserById(@RequestParam(value = "userId") Long userId, String userName, String passWord, Integer age) {
        try {
            if (ObjectUtils.isEmpty(userId))
                return ResultTools.result(1001, "", null);
            UserBean user = new UserBean();
            user.setId(userId);
            user.setUsername(userName);
            user.setPassword(passWord);
            user.setAge(age);
            int code = userMapper.updateUser(user);
            if (1 == code) return ResultTools.result(0, "修改成功", null);
            UserBean userBean = userMapper.findUserById(userId);
            if (ObjectUtils.isEmpty(userBean))
                return ResultTools.result(1002, "未查询到该用户", null);
            return ResultTools.result(404, "修改失败", null);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @ApiOperation(value = "根据userId删除用户")
    @ApiImplicitParam(name = "id", value = "userId", paramType = "query", required = true, dataType = "Long")
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.POST)
    public ResultModel deleteUserById(@RequestParam(value = "userId") Long userId) {
        try {
            if (ObjectUtils.isEmpty(userId))
                return ResultTools.result(1001, "", null);
            int code = userMapper.deleteUserById(userId);
            if (1 == code) return ResultTools.result(0, "删除成功", null);
            UserBean userBean = userMapper.findUserById(userId);
            if (ObjectUtils.isEmpty(userBean))
                return ResultTools.result(1002, "未查询到该用户", null);
            return ResultTools.result(404, "删除失败", null);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @ApiOperation(value = "根据userName删除用户")
    @ApiImplicitParam(name = "username", value = "userName", paramType = "query", required = true)
    @RequestMapping(value = "/deleteUserByName", method = RequestMethod.POST)
    public ResultModel deleteUserByName(@RequestParam(value = "userName") String userName, String type) {
        try {
            if (ObjectUtils.isEmpty(userName))
                return ResultTools.result(1001, "", null);
            int code;
            if ("like".equals(type)) code = userMapper.deleteUserLikeName(userName);
            else code = userMapper.deleteUserByName(userName);
            if (0 != code) return ResultTools.result(0, "删除成功", null);
            List<UserBean> userBeans = userMapper.findUserLikeName(userName);
            if (ObjectUtils.isEmpty(userBeans) || userBeans.size() == 0)
                return ResultTools.result(1002, "未查询到符合条件用户", null);
            return ResultTools.result(404, "删除失败", null);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }
}