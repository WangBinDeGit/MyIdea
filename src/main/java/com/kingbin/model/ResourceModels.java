package com.kingbin.model;

import java.util.List;

/**
 * Created by WangBin on 2018/11/23
 */
public class ResourceModels {
    private String ID;
    private String PID;
    private String RES_CODE;
    private String RES_NAME;
    private String RES_TYPE;
    private int RES_LEVEL;
    private String RES_ICON;
    private String RES_URL;
    private String RES_DESC;
    private String CREATOR;
    private String CREATE_TIME;
    private List<ResourceModels> children;

    public ResourceModels(String id, String parentId, String resName, int level) {
        super();
        this.ID = id;
        this.PID = parentId;
        this.RES_NAME = resName;
        this.RES_LEVEL = level;
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getRES_CODE() {
        return RES_CODE;
    }

    public void setRES_CODE(String RES_CODE) {
        this.RES_CODE = RES_CODE;
    }

    public String getRES_NAME() {
        return RES_NAME;
    }

    public void setRES_NAME(String RES_NAME) {
        this.RES_NAME = RES_NAME;
    }

    public String getRES_TYPE() {
        return RES_TYPE;
    }

    public void setRES_TYPE(String RES_TYPE) {
        this.RES_TYPE = RES_TYPE;
    }

    public int getRES_LEVEL() {
        return RES_LEVEL;
    }

    public void setRES_LEVEL(int RES_LEVEL) {
        this.RES_LEVEL = RES_LEVEL;
    }

    public String getRES_ICON() {
        return RES_ICON;
    }

    public void setRES_ICON(String RES_ICON) {
        this.RES_ICON = RES_ICON;
    }

    public String getRES_URL() {
        return RES_URL;
    }

    public void setRES_URL(String RES_URL) {
        this.RES_URL = RES_URL;
    }

    public String getRES_DESC() {
        return RES_DESC;
    }

    public void setRES_DESC(String RES_DESC) {
        this.RES_DESC = RES_DESC;
    }

    public String getCREATOR() {
        return CREATOR;
    }

    public void setCREATOR(String CREATOR) {
        this.CREATOR = CREATOR;
    }

    public String getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(String CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    public List<ResourceModels> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceModels> children) {
        this.children = children;
    }


}
