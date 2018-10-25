package com.kingbin.service;

import com.kingbin.mapper.UserMapper;
import com.kingbin.model.ResultModel;
import com.kingbin.model.ResultTools;
import com.kingbin.model.UserBean;
import com.kingbin.tools.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by WangBin on 2018/10/25
 * 登陆Service
 */
@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultModel loginByName(UserBean userBean, HttpServletRequest request) {
        if (ObjectUtils.isEmpty(userBean.getUserName()) || ObjectUtils.isEmpty(userBean.getPassWord()))
            return ResultTools.result(1001, "输入用户名或密码为空", null);
        List<UserBean> user = userMapper.findUserByUser(userBean);
        if (user != null && user.size() > 0) {
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return ResultTools.result(0, "登陆成功", null);
        } else {
            List<UserBean> users = userMapper.findUserByName(userBean.getUserName());
            if (users != null && users.size() > 0) return ResultTools.result(0, "输入的密码错误", null);
            else return ResultTools.result(1002, "用户名不存在", null);
        }
    }
}
