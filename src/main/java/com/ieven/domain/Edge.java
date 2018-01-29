package com.ieven.domain;

import org.neo4j.ogm.annotation.GraphId;

/**
 * Created by wangdechang on 2018/1/25
 */
public class Edge extends Graph{
    private String from;
    private String to;
    private float strength;
    private String code;
    private String details;
    private int id;
    private String name;
    private int type;

    public Edge(){

    }

    public Edge(String from, String to, float strength, String code, String details, int id, String name, int type) {
        this.from = from;
        this.to = to;
        this.strength = strength;
        this.code = code;
        this.details = details;
        this.id = id;
        this.name = name;
        this.type = type;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (Float.compare(edge.getStrength(), getStrength()) != 0) return false;
        if (getId() != edge.getId()) return false;
        if (getType() != edge.getType()) return false;
        if (getFrom() != null ? !getFrom().equals(edge.getFrom()) : edge.getFrom() != null) return false;
        if (getTo() != null ? !getTo().equals(edge.getTo()) : edge.getTo() != null) return false;
        if (getCode() != null ? !getCode().equals(edge.getCode()) : edge.getCode() != null) return false;
        if (getDetails() != null ? !getDetails().equals(edge.getDetails()) : edge.getDetails() != null) return false;
        return getName() != null ? getName().equals(edge.getName()) : edge.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getFrom() != null ? getFrom().hashCode() : 0;
        result = 31 * result + (getTo() != null ? getTo().hashCode() : 0);
        result = 31 * result + (getStrength() != +0.0f ? Float.floatToIntBits(getStrength()) : 0);
        result = 31 * result + (getCode() != null ? getCode().hashCode() : 0);
        result = 31 * result + (getDetails() != null ? getDetails().hashCode() : 0);
        result = 31 * result + getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getType();
        return result;
    }
}
