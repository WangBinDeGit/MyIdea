package com.kingbin.controller;

import com.kingbin.model.ResultModel;
import com.kingbin.model.UserBean;
import com.kingbin.service.LoginService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping(name = "/loginByName")
    public ResultModel loginByName(UserBean userBean, HttpServletRequest request) {
        return loginService.loginByName(userBean, request);
    }
}
