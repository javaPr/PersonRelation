package com.ieven.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * Created by wangdechang on 2018/1/25
 */
@QueryResult
public class Result {
    Person startPerson;
    Relation relation;
    Person endPerson;

    public Result(){

    }

    public Person getStartPerson() {
        return startPerson;
    }

    public void setStartPerson(Person startPerson) {
        this.startPerson = startPerson;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    public Person getEndPerson() {
        return endPerson;
    }

    public void setEndPerson(Person endPerson) {
        this.endPerson = endPerson;
    }
}
