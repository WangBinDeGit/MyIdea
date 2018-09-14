package com.kingbin.controller; /**
 * Created by WangBin on 2018/4/11.
 * name
 */

import com.kingbin.bean.UserBean;
import com.kingbin.mydao.UserDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by wangbin  on 2018/4/11.
 */
@RestController
@RequestMapping(value = "/user")
@Api(description = "用户")
public class UserController {

    @Resource
    UserDao userDAO;

    @ApiOperation(value = "添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "username", paramType = "query", required = true),
            @ApiImplicitParam(name = "password", value = "password", paramType = "query", required = true),
            @ApiImplicitParam(name = "age", value = "age", paramType = "query", required = true, dataType = "int")
    })
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestParam(value = "username") String name, @RequestParam(value = "password") String password,
                          @RequestParam(value = "age") int age) {

        UserBean user = new UserBean();
        user.setUsername(name);
        user.setPassword(password);
        user.setAge(age);
        userDAO.save(user);
        return "add user success !";
    }

    @ApiOperation(value = "查找用户")
    @ApiImplicitParam(name = "id", value = "userid", paramType = "query", required = true, dataType = "long")
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    public UserBean findById(@RequestParam(value = "userid") long userid) {

        UserBean user = userDAO.findById(userid);

        if (user == null) return null;
        else return user;
    }

    @ApiOperation(value = "查找用户")
    @ApiImplicitParam(name = "username", value = "username", paramType = "query", required = true)
    @RequestMapping(value = "/findByName", method = RequestMethod.POST)
    public Iterable<UserBean> findByName(@RequestParam(value = "username") String username) {

        Iterable<UserBean> users = userDAO.findAll();

        if (users == null) return null;
        else return users;
    }

    @ApiOperation(value = "查询所有用户")
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public Iterable<UserBean> findAll() {

        return userDAO.findAll();

    }

    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "id", value = "userid", paramType = "query", required = true, dataType = "long")
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public String deleteById(@RequestParam(value = "userid") long id) {

        userDAO.delete(id);

        return "delete success !";
    }

    @ApiOperation(value = "修改用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "userid", paramType = "query", required = true, dataType = "long"),
            @ApiImplicitParam(name = "username", value = "username", paramType = "query", required = true),
            @ApiImplicitParam(name = "password", value = "password", paramType = "query", required = true),
            @ApiImplicitParam(name = "age", value = "age", paramType = "query", required = true, dataType = "int")
    })
    @RequestMapping(value = "/upDataUser", method = RequestMethod.POST)
    public String upDataUser(@RequestParam(value = "userid") long userid, @RequestParam(value = "username") String username,
                             @RequestParam(value = "password") String password, @RequestParam(value = "age") int age) {

        UserBean user = userDAO.findById(userid);
        if (user == null) return "未查询到要修改的用户";
        user.setUsername(username);
        user.setPassword(password);
        user.setAge(age);
        userDAO.save(user);
        return "updata success !";
    }

}