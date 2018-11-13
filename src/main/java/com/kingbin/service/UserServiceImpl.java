package com.kingbin.service;

import com.kingbin.mapper.UserMapper;
import com.kingbin.model.ResultModel;
import com.kingbin.model.ResultTools;
import com.kingbin.model.UserBean;
import com.kingbin.tools.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by WangBin on 2018/10/23
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultModel findUserByAll() {
        try {
            Iterable<UserBean> users = userMapper.findUserByAll();
            return ResultTools.result(200, "", users);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @Override
    public ResultModel findUserById(Long userId) {
        try {
            if (ObjectUtils.isEmpty(userId))
                return ResultTools.result(1001, "", null);
            UserBean user = userMapper.findUserById(userId);
            return ResultTools.result(200, "", user);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @Override
    public ResultModel findUserByName(String userName, String type) {
        try {
            if (ObjectUtils.isEmpty(userName))
                return ResultTools.result(1001, "", null);
            Iterable<UserBean> users;
            if ("like".equals(type)) users = userMapper.findUserLikeName(userName);
            else users = userMapper.findUserByName(userName);
            return ResultTools.result(200, "", users);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @Override
    public ResultModel findUserByUser(String userName, String passWord, Integer age) {
        try {
            UserBean user = new UserBean();
            user.setUserName(userName);
            user.setPassWord(passWord);
            user.setUserAge(age);
            Iterable<UserBean> users = userMapper.findUserByUser(user);
            return ResultTools.result(200, "", users);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @Override
    public ResultModel addUser(String userName, String passWord, Integer age) {
        try {
            UserBean user = new UserBean();
            user.setUserName(userName);
            user.setPassWord(passWord);
            user.setUserAge(age);
            user.setUserSex(1);
            int code = userMapper.addUser(user);
            if (1 == code) return ResultTools.result(0, "添加成功", null);
            else return ResultTools.result(200, "添加失败", null);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @Override
    public ResultModel addUsers(UserBean user) {
        try {
            if (ObjectUtils.isEmpty(user) || ObjectUtils.isEmpty(user.getUserName()))
                return ResultTools.result(1001, "", null);
            if (ObjectUtils.isEmpty(user.getUserSex())) user.setUserSex(1);
            int code = userMapper.addUser(user);
            if (1 == code) return ResultTools.result(200, "添加成功", null);
            else return ResultTools.result(200, "添加失败", null);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @Override
    public ResultModel upDataUserById(Long userId, String userName, String passWord, Integer userAge) {
        try {
            if (ObjectUtils.isEmpty(userId) || (ObjectUtils.isEmpty(userName) && ObjectUtils.isEmpty(passWord) && ObjectUtils.isEmpty(userAge)))
                return ResultTools.result(1001, "", null);
            UserBean user = new UserBean();
            user.setUserId(userId);
            user.setUserName(userName);
            user.setPassWord(passWord);
            user.setUserAge(userAge);
            int code = userMapper.updateUser(user);
            if (1 == code) return ResultTools.result(200, "修改成功", null);
            UserBean userBean = userMapper.findUserById(userId);
            if (ObjectUtils.isEmpty(userBean))
                return ResultTools.result(1002, "未查询到该用户", null);
            return ResultTools.result(404, "修改失败", null);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @Override
    public ResultModel upDataUserByUser(UserBean user) {
        try {
            if (ObjectUtils.isEmpty(user) || ObjectUtils.isEmpty(user.getUserId()) ||
                    (ObjectUtils.isEmpty(user.getUserName()) && ObjectUtils.isEmpty(user.getPassWord())
                            && ObjectUtils.isEmpty(user.getUserSex()) && ObjectUtils.isEmpty(user.getUserAge())
                            && ObjectUtils.isEmpty(user.getUserSex()) && ObjectUtils.isEmpty(user.getUserAddress())
                            && ObjectUtils.isEmpty(user.getUserPhoto())))
                return ResultTools.result(1001, "", null);
            int code = userMapper.updateUser(user);
            if (1 == code) return ResultTools.result(200, "修改成功", null);
            UserBean userBean = userMapper.findUserById(user.getUserId());
            if (ObjectUtils.isEmpty(userBean))
                return ResultTools.result(1002, "未查询到该用户", null);
            return ResultTools.result(404, "修改失败", null);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @Override
    public ResultModel deleteUserById(Long userId) {
        try {
            if (ObjectUtils.isEmpty(userId))
                return ResultTools.result(1001, "", null);
            int code = userMapper.deleteUserById(userId);
            if (1 == code) return ResultTools.result(200, "删除成功", null);
            UserBean userBean = userMapper.findUserById(userId);
            if (ObjectUtils.isEmpty(userBean))
                return ResultTools.result(1002, "未查询到该用户", null);
            return ResultTools.result(404, "删除失败", null);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @Override
    public ResultModel deleteUserByName(String userName, String type) {
        try {
            if (ObjectUtils.isEmpty(userName))
                return ResultTools.result(1001, "", null);
            int code;
            if ("like".equals(type)) code = userMapper.deleteUserLikeName(userName);
            else code = userMapper.deleteUserByName(userName);
            if (0 != code) return ResultTools.result(200, "删除成功", null);
            List<UserBean> userBeans = userMapper.findUserLikeName(userName);
            if (ObjectUtils.isEmpty(userBeans) || userBeans.size() == 0)
                return ResultTools.result(1002, "未查询到符合条件用户", null);
            return ResultTools.result(404, "删除失败", null);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }
}
