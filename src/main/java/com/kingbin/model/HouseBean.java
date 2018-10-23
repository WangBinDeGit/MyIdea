package com.kingbin.model;

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
    private long houseId;
    private String houseTitle;
    private String houseContent;
    private String userId;

    public long getHouseId() {
        return houseId;
    }

    public void setHouseId(long houseId) {
        this.houseId = houseId;
    }

    public String getHouseTitle() {
        return houseTitle;
    }

    public void setHouseTitle(String houseTitle) {
        this.houseTitle = houseTitle;
    }

    public String getHouseContent() {
        return houseContent;
    }

    public void setHouseContent(String houseContent) {
        this.houseContent = houseContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
