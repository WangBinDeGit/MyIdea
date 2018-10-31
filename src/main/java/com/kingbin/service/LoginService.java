package com.kingbin.service;

import com.kingbin.model.ResultModel;
import com.kingbin.model.UpdateModel;
import com.kingbin.model.UserBean;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by WangBin on 2018/10/25
 */
public interface LoginService {

    ResultModel loginByName(UserBean userBean, HttpServletRequest request);

    ResultModel loginByPhone(UserBean userBean, HttpServletRequest request);

    UpdateModel isUpdate();

}
