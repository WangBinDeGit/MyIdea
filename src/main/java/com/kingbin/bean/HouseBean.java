package com.kingbin.bean;

import javax.persistence.*;

/**
 * Created by WangBin on 2018/4/12.
 * HouseBean 映射house表
 */

@Entity
@Table(name = "house")
public class HouseBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String housetitle;
    private String housecontent;
    private String userid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHousetitle() {
        return housetitle;
    }

    public void setHousetitle(String housetitle) {
        this.housetitle = housetitle;
    }

    public String getHousecontent() {
        return housecontent;
    }

    public void setHousecontent(String housecontent) {
        this.housecontent = housecontent;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
