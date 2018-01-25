package com.ieven.domain;

import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * Created by wangdechang on 2018/1/24
 */
@QueryResult
public class OneLayerRelationResult {
    private String idnumber1;
    private String idnumber2;
    private float strength;
    private String code;
    private String detail;
    private int id;
    private String name;
    private int type;

    public OneLayerRelationResult() {
    }

    public String getIdnumber1() {
        return idnumber1;
    }

    public void setIdnumber1(String idnumber1) {
        this.idnumber1 = idnumber1;
    }

    public String getIdnumber2() {
        return idnumber2;
    }

    public void setIdnumber2(String idnumber2) {
        this.idnumber2 = idnumber2;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
