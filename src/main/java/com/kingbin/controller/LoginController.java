package com.kingbin.controller;

import com.kingbin.model.ResultModel;
import com.kingbin.model.UpdateModel;
import com.kingbin.model.UserBean;
import com.kingbin.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by WangBin on 2018/10/25
 */
@RestController
@RequestMapping(value = "/login")
@Api(description = "用户登陆")
public class LoginController {

    @Autowired
    LoginService loginService;

    @ApiOperation(value = "用户名登陆界面")
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @ApiOperation(value = "通过用户名登陆")
    @RequestMapping(value = "/loginByName", method = RequestMethod.POST)
    public ResultModel loginByName(UserBean userBean, HttpServletRequest request) {
        return loginService.loginByName(userBean, request);
    }

    @ApiOperation(value = "通过手机号登陆")
    @RequestMapping(value = "/loginByPhone", method = RequestMethod.POST)
    public ResultModel loginByPhone(UserBean userBean, HttpServletRequest request) {
        return loginService.loginByPhone(userBean, request);
    }

    @ApiOperation(value = "判断是否升级")
    @RequestMapping(value = "/isUpdate", method = RequestMethod.GET)
    public UpdateModel isUpdate() {
        return loginService.isUpdate();
    }

}
