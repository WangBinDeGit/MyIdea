package com.kingbin.model;

import com.kingbin.tools.ObjectUtils;

import java.util.Map;

/**
 * Created by WangBin on 2018/10/10
 * 请求结果处理类
 */
public class ResultTools {
    /**
     * 错误码记录：
     * 200--------成功
     * 1001-----请求传参错误
     * 1002-----没有对应内容
     * 1003-----此用户已存在
     * 1004-----上传文件为空
     * 404------异常抛出错误
     *
     * @param Errcode--返回码
     * @param Errmsg---404服务器内部异常时提示消息(返回码不是404时传空即可)
     * @param o------数据源
     * @return
     */
    public static ResultModel result(int Errcode, String Errmsg, Object o) {
        ResultModel model = new ResultModel();
        model.setStatusCode(Errcode);
        switch (Errcode) {
            case 200:
                if (ObjectUtils.isEmpty(Errmsg))
                    model.setMessage("成功");
                else model.setMessage(Errmsg);
                if (o != null)
                    model.setData(o);
                break;
            case 1001:
                if (ObjectUtils.isEmpty(Errmsg))
                    model.setMessage("请求传参错误 ");
                else model.setMessage(Errmsg);
                break;
            case 1002:
                if (ObjectUtils.isEmpty(Errmsg))
                    model.setMessage("没有对应内容 ");
                else model.setMessage(Errmsg);
                break;
            case 1003:
                model.setMessage("此用户已存在");
                break;
            case 1004:
                model.setMessage("上传文件为空");
                break;
            case 404:
                model.setMessage(Errmsg);
                break;
            default:
                model.setMessage("未知错误");
                break;
        }
        return model;
    }
}

