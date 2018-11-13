package com.kingbin.model;

import java.util.Map;

/**
 * Created by WangBin on 2018/10/10
 * 返回封装总类
 */
public class ResultModel {

    private int statusCode;// 返回码
    private String message;// 返回消息
    private Object data;// 数据源

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
