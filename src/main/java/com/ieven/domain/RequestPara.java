package com.ieven.domain;

/**
 * Created by wangdechang on 2018/1/29
 */
public class RequestPara {
    private String[] idnumber;
    private Float[] personStrength;
    private Float[] groupStrength;
    private Float[] classStrength;
    private Float[] basicStrength;
    private Integer limit;

    public RequestPara(){

    }

    public String[] getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String[] idnumber) {
        this.idnumber = idnumber;
    }

    public Float[] getPersonStrength() {
        return personStrength;
    }

    public void setPersonStrength(Float[] personStrength) {
        this.personStrength = personStrength;
    }

    public Float[] getGroupStrength() {
        return groupStrength;
    }

    public void setGroupStrength(Float[] groupStrength) {
        this.groupStrength = groupStrength;
    }

    public Float[] getClassStrength() {
        return classStrength;
    }

    public void setClassStrength(Float[] classStrength) {
        this.classStrength = classStrength;
    }

    public Float[] getBasicStrength() {
        return basicStrength;
    }

    public void setBasicStrength(Float[] basicStrength) {
        this.basicStrength = basicStrength;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
