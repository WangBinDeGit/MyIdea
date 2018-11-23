package com.kingbin.model;

import javax.persistence.*;

/**
 * Created by WangBin on 2018/11/23
 */
@Entity
@Table(name = "traceability")
public class TraceabilityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String equId;
    private String equName;
    private String subId;
    private String subName;
    private String pmCode;
    private String unitName;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getEquId() {
        return equId;
    }

    public void setEquId(String equId) {
        this.equId = equId;
    }

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
