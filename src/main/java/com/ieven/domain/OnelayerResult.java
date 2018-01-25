package com.ieven.domain;


import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * Created by wangdechang on 2018/1/24
 */

@QueryResult
public class OnelayerResult {
    private String idnumber;
    private String name;
    private String keynumber;
    private float strength;
    private String code;
    private String detail;
    private int id;
    private String rname;
    private int rtype;

    public OnelayerResult() {
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public int getRtype() {
        return rtype;
    }

    public void setRtype(int rtype) {
        this.rtype = rtype;
    }

    public String getKeynumber() {
        return keynumber;
    }

    public void setKeynumber(String keynumber) {
        this.keynumber = keynumber;
    }

    public float getStrength() {
        return strength;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
