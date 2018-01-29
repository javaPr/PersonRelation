package com.ieven.repository;

import com.ieven.domain.*;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by wangdechang on 2018/1/23
 */
@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    Person findByName(@Param("name") String name);

    Person findByIdnumber(@Param("idnumber") String idnumber);

    @Query("Match (n:Person{idnumber:{idnumber}})-[r:Relation]-(p:Person) return n,r,p order by p.idnumber")
    Collection<Person> getPerson(@Param("idnumber") String idnumber);


//    @Query("Match (n:Person{idnumber:{idnumber}})-[r:Relation]-(p:Person) return n as startPerson,r as relation,p as endPerson order by p.idnumber")
//    Collection<Result> getGraph(@Param("idnumber")String idnumber);


    @Query("Match (n:Person{idnumber:{idnumber}})-[r:Relation]-(p:Person) return n,r,p order by p.idnumber")
    Collection<Relation> getRelation(@Param("idnumber") String idnumber);

    @Query("Match (n:Person{idnumber:{idnumber}})-[r:Relation]-(p:Person) return p.idnumber as idnumber,p.name as name,p.keynumber as keynumber," +
            "r.strength as strength,r.code as code,r.name as rname, r.details as details,r.type as rtype,ID(r) as id order by p.idnumber")
    Collection<OnelayerResult> getOneLayer(@Param("idnumber") String idnumber);

    @Query("Match (p1:Person)-[r1:Relation{type:4}]-(n:Person{idnumber:{idnumber}})-[r2:Relation{type:4}]-(p2:Person) " +
            "with p1,p2 match (p1)-[r:Relation]-(p2) where p1.idnumber < p2.idnumber " +
            "return p1.idnumber as idnumber1,p2.idnumber as idnumber2,r.strength as strength,r.code as code," +
            "r.name as name,r.details as detail,r.type as type, ID(r) as id order by p1.idnumber,p2.idnumber limit {limit}")
    Collection<OneLayerRelationResult> getOneLayerRelation(@Param("idnumber") String idnumber, @Param("limit") int limit);

    @Query("match (n:Person{idnumber:{idnumber}})-[r:Relation]-(p:Person) " +
            "where  r.code=~ '.*R.*'  and r.strength>={minvalue} and r.strength<={maxvalue} " +
            "return p.idnumber as idnumber,p.name as name,p.keynumber as keynumber," +
            "r.strength as strength,r.code as code,r.name as rname, r.details as details," +
            "r.type as rtype,ID(r) as id order by p.idnumber")
    Collection<OnelayerResult> getPersonRelation(
            @Param("idnumber") String idnumber,
            @Param("minvalue") float minvalue,
            @Param("maxvalue") float maxvalue);

    @Query("match (n:Person{idnumber:{idnumber}})-[r:Relation]-(p:Person) " +
            "where  r.code=~ '.*R.*'  and r.strength>={minvalue} and r.strength<={maxvalue} " +
            "return p.idnumber as idnumber,p.name as name,p.keynumber as keynumber," +
            "p.alias as alias,labels(p) as labels,r.strength as strength," +
            "n.idnumber as from,p.idnumber as to, r.code as code,r.name as rname," +
            "r.details as details,r.type as rtype,ID(r) as id order by p.idnumber")
    Collection<NodeEdge> getPersonRelationNet(
            @Param("idnumber") String idnumber,
            @Param("minvalue") float minvalue,
            @Param("maxvalue") float maxvalue
    );

    @Query("match (n:Person{idnumber:{idnumber}})-[r:Relation]-(p:Person) " +
            "where  r.code=~ '.*G.*'  and r.strength>={minvalue} and r.strength<={maxvalue} " +
            "return p.idnumber as idnumber,p.name as name,p.keynumber as keynumber," +
            "p.alias as alias,labels(p) as labels,r.strength as strength," +
            "n.idnumber as from,p.idnumber as to, r.code as code,r.name as rname," +
            "r.details as details,r.type as rtype,ID(r) as id order by p.idnumber")
    Collection<NodeEdge> getGroupRelationNet(
            @Param("idnumber") String idnumber,
            @Param("minvalue") float minvalue,
            @Param("maxvalue") float maxvalue
    );

    @Query("match (n:Person{idnumber:{idnumber}})-[r:Relation]-(p:Person) " +
            "where  r.code=~ '.*C.*'  and r.strength>={minvalue} and r.strength<={maxvalue} " +
            "return p.idnumber as idnumber,p.name as name,p.keynumber as keynumber," +
            "p.alias as alias,labels(p) as labels,r.strength as strength," +
            "n.idnumber as from,p.idnumber as to, r.code as code,r.name as rname," +
            "r.details as details,r.type as rtype,ID(r) as id order by p.idnumber")
    Collection<NodeEdge> getClassRelationNet(
            @Param("idnumber") String idnumber,
            @Param("minvalue") float minvalue,
            @Param("maxvalue") float maxvalue
    );

    @Query("match (n:Person{idnumber:{idnumber}})-[r:Relation]-(p:Person) " +
            "where  r.code=~ '.*B.*'  and r.strength>={minvalue} and r.strength<={maxvalue} " +
            "return p.idnumber as idnumber,p.name as name,p.keynumber as keynumber," +
            "p.alias as alias,labels(p) as labels,r.strength as strength," +
            "n.idnumber as from,p.idnumber as to, r.code as code,r.name as rname," +
            "r.details as details,r.type as rtype,ID(r) as id order by p.idnumber")
    Collection<NodeEdge> getBasicRelationNet(
            @Param("idnumber") String idnumber,
            @Param("minvalue") float minvalue,
            @Param("maxvalue") float maxvalue
    );


    @Query("match (p:Person{idnumber:{idnumber}}) return p.idnumber as idnumber," +
            "p.name as name,p.keynumber as keynumber,p.alias as alias,labels(p) as labels")
    Node getNodeById(@Param("idnumber")String idnumber);

}
