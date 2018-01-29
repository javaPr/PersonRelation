package com.ieven.domain;

import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.Arrays;

/**
 * Created by wangdechang on 2018/1/25
 */
@QueryResult
public class Node extends Graph{
    private String idnumber;
    private String alias = "";
    private String name = "";
    private String keynumber = "";
    private String[] labels;

    public Node() {
    }

    public Node(String idnumber, String alias, String name, String keynumber, String[] labels) {
        this.idnumber = idnumber;
        this.alias = alias;
        this.name = name;
        this.keynumber = keynumber;
        this.labels = labels;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (getIdnumber() != null &&!getIdnumber().equals(node.getIdnumber())) return false;
        if (getAlias() != null && !getAlias().equals(node.getAlias())) return false;
        if (getName() != null && !getName().equals(node.getName())) return false;
        if (getKeynumber() != null && !getKeynumber().equals(node.getKeynumber())) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getLabels(), node.getLabels());
    }

    @Override
    public int hashCode() {
        int result = getIdnumber().hashCode();
        result = 31 * result + (getAlias() != null ? getAlias().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getKeynumber() != null ? getKeynumber().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getLabels());
        return result;
    }
}

