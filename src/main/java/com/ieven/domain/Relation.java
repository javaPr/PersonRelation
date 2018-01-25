package com.ieven.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import java.util.ArrayList;

/**
 * Created by wangdechang on 2018/1/24
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@RelationshipEntity(type = "Relation")
public class Relation {

    @GraphId
    private Long id;
    private String from;
    private String to;
    private int type;    //1234
    private String label;       //name
    private double strength;
    private String updateTime;
    private String code;
    private String name;
    private String details;
    private ArrayList<String> fatherIds = new ArrayList<>();
    private String[] childrenIds;

    @StartNode
    private Person startPerson;

    @EndNode
    private Person person;

    public Relation(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<String> getFatherIds() {
        return fatherIds;
    }

    public void setFatherIds(ArrayList<String> fatherIds) {
        this.fatherIds = fatherIds;
    }

    public String[] getChildrenIds() {
        return childrenIds;
    }

    public void setChildrenIds(String[] childrenIds) {
        this.childrenIds = childrenIds;
    }

    public Person getStartPerson() {
        return startPerson;
    }

    public void setStartPerson(Person startPerson) {
        this.startPerson = startPerson;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
