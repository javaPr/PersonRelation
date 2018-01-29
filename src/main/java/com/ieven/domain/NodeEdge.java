package com.ieven.domain;

import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * Created by wangdechang on 2018/1/25
 */
@QueryResult
public class NodeEdge {
    //Node info
    private String idnumber;
    private String alias;
    private String name;
    private String keynumber;
    private String[] labels;
    //Edge info
    private String from;
    private String to;
    private float strength;
    private String code;
    private String detail;
    private int id;
    private String rname;
    private int rtype;

    public NodeEdge() {
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeynumber() {
        return keynumber;
    }

    public void setKeynumber(String keynumber) {
        this.keynumber = keynumber;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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
}
