package com.kingbin.controller; /**
 * Created by WangBin on 2018/4/11.
 * name
 */

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
import java.util.Map;

/**
 * Created by wangbin  on 2018/4/11.
 */
@RestController
@RequestMapping(value = "/user")
@Api(description = "用户")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "查询所有用户")
    @RequestMapping(value = "/findUserByAll", method = RequestMethod.POST)
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
    public ResultModel findUserByName(@RequestParam(value = "userName") String userName) {
        try {
            if (ObjectUtils.isEmpty(userName))
                return ResultTools.result(1001, "", null);
            Iterable<UserBean> users = userMapper.findUserByName(userName);
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
    public ResultModel addUser(@RequestParam(value = "userName") String userName, @RequestParam(value = "passWord") String passWord,
                               @RequestParam(value = "age") Integer age) {
        try {
            if (ObjectUtils.isEmpty(age)) age = 0;
            UserBean user = new UserBean();
            user.setUsername(userName);
            user.setPassword(passWord);
            user.setAge(age);
            int code = userMapper.addUser(user);
            if (1 == code)
                return ResultTools.result(0, "添加成功", null);
            return ResultTools.result(404, "添加失败", null);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
//            userDAO.save(user);
//            return "add user success !";

    }


    @ApiOperation(value = "修改用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "userId", paramType = "query", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "username", value = "userName", paramType = "query", required = true),
            @ApiImplicitParam(name = "password", value = "passWord", paramType = "query", required = true),
            @ApiImplicitParam(name = "age", value = "age", paramType = "query", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/upDataUserById", method = RequestMethod.POST)
    public ResultModel upDataUserById(@RequestParam(value = "userId") Long userId, @RequestParam(value = "userName") String userName,
                                      @RequestParam(value = "passWord") String passWord, @RequestParam(value = "age") Integer age) {
        try {
            if (ObjectUtils.isEmpty(userId))
                return ResultTools.result(1001, "", null);
            if (ObjectUtils.isEmpty(age)) age = 0;
            UserBean user = new UserBean();
            user.setId(userId);
            user.setUsername(userName);
            user.setPassword(passWord);
            user.setAge(age);
            int code = userMapper.updateUser(user);
            if (1 == code)
                return ResultTools.result(0, "修改成功", null);
            UserBean userBean = userMapper.findUserById(userId);
            if (ObjectUtils.isEmpty(userBean))
                return ResultTools.result(404, "未查询到该用户", null);
            return ResultTools.result(404, "修改失败", null);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }

//        UserBean user = userMapper.findById(userid);
//        if (user == null) return "未查询到要修改的用户";
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setAge(age);
//        userDAO.save(user);
//        return "updata success !";
    }

    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "id", value = "userId", paramType = "query", required = true, dataType = "Long")
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.POST)
    public ResultModel deleteUserById(@RequestParam(value = "userId") Long userId) {
        try {
            if (ObjectUtils.isEmpty(userId))
                return ResultTools.result(1001, "", null);
            int code = userMapper.deleteUserById(userId);
            if (1 == code)
                return ResultTools.result(0, "删除成功", null);
            UserBean userBean = userMapper.findUserById(userId);
            if (ObjectUtils.isEmpty(userBean))
                return ResultTools.result(404, "未查询到该用户", null);
            return ResultTools.result(404, "删除失败", null);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }


}