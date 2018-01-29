package com.ieven.controller;

import com.google.gson.Gson;
import com.ieven.domain.*;
import com.ieven.services.PersonService;
import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.runtime.arrays.IteratorAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by wangdechang on 2018/1/23
 */
@RestController
public class PersonController {

    final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/getPersonByName")
    public Map<String, Person> getPersonByname(@RequestParam(value = "name") String name) {
        Person person = personService.getPersonByName(name);
        Map<String, Person> map = new HashMap<>();
        map.put("person", person);
        return map;
    }

    /**
     * 查找对应身份证号的人是否存在
     * @param idnumber
     * @return
     */
    @RequestMapping(value = "/getPersonById")
    public Map<String, Person> getPersonByIdNumber(@RequestParam(value = "idnumber") String idnumber) {
        Person person = personService.getPersonByIdnumber(idnumber);
        Map<String, Person> map = new HashMap<>();
        map.put("person", person);
        return map;
    }


    /*@RequestMapping(value = "/getGraph")
    public Map<String, List<Result>> getGraph(@RequestParam(value = "idnumber") String idnumber) {
        //Person person = personService.getPersonByIdnumber(idnumber);
        Collection<Result> results = personService.gerGraph(idnumber);
        Iterator<Result> iterator = results.iterator();
        List<Result> resultList = new ArrayList<>();
        while (iterator.hasNext()){
            resultList.add(iterator.next());
        }
        Gson gson = new Gson();

        Map<String, List<Result>> map = new HashMap<>();
        map.put("person", resultList);
        return map;
    }*/

    /**
     * 判断身份证号对应的人是否存在
     * @param idnumberArr 传入的包含身份证号的数组
     * @return
     */
    @RequestMapping(value = "/checkIsExist", method = RequestMethod.POST)
    public Map<String, Boolean> getPersonByArrId(@RequestParam(value = "idnumberArr") String[] idnumberArr) {
        System.out.println(idnumberArr.length);
        Map<String, Boolean> map = new HashMap<>();
        if (idnumberArr != null && idnumberArr.length > 0) {
            for (String id:idnumberArr){
                Person person = personService.getPersonByIdnumber(id);
                if (person != null){
                    map.put(id,true);
                }else{
                    map.put(id,false);
                }
            }
        }
        return map;
    }

    @RequestMapping(value = "/getPersonRelation")
    public Map<String, List<Person>> getPersonRelation(@RequestParam(value = "idnumber") String idnumber) {
        Collection<Person> personCollection = personService.getPersonRelation(idnumber);
        System.out.println(personCollection.size());
        Map<String, List<Person>> map = new HashMap<>();
        Iterator<Person> iterator = personCollection.iterator();
        List<Person> personList = new ArrayList<>();
        while (iterator.hasNext()) {
            personList.add(iterator.next());
        }
        map.put("person", personList);
        return map;
    }

    /**
     * 获取一层关系人，即通过节点查找与节点有关联的关系线
     *
     * @param idnumber
     * @return
     */
    @RequestMapping(value = "/getOneLayer",method = RequestMethod.POST)
    public Map<String, List<OnelayerResult>> getOneLayer(
            @RequestParam(value = "idnumber") String[] idnumber,
            @RequestParam(value = "limit", required = false) Integer limit) {
        System.out.println("idnumber = "+idnumber+" limit = "+ limit);
        Collection<OnelayerResult> relations = personService.getOneLayer(idnumber[0]);
        Map<String, List<OnelayerResult>> map = new HashMap<>();
        List<OnelayerResult> relationList = new ArrayList<>();
        Iterator<OnelayerResult> iterator = relations.iterator();
        while (iterator.hasNext()) {
            relationList.add(iterator.next());
        }
        map.put("node2node", relationList);
        return map;
    }


    /**
     * 查找一层关系人对应的关系
     * @param idnumber
     * @param limit
     * @return
     */
    @RequestMapping("/getOneLayerRelation")
    public Map<String, List<OneLayerRelationResult>> getOneLayerRelation(
            @RequestParam(value = "idnumber") String idnumber,
            @RequestParam(value = "limit", required = false) Integer limit) {

        Collection<OneLayerRelationResult> relationResults = personService.getOneLayerRelation(idnumber, limit == null ? 10 : limit);
        Map<String, List<OneLayerRelationResult>> map = new HashMap<>();
        List<OneLayerRelationResult> relationResultList = new ArrayList<>();
        Iterator<OneLayerRelationResult> iterator = relationResults.iterator();
        while (iterator.hasNext()) {
            relationResultList.add(iterator.next());
        }
        map.put("relation", relationResultList);
        return map;

    }


    @RequestMapping("/getPersonRelationList")
    public Map<String,List<OnelayerResult>> getPersonRelation(){
        Map<String,List<OnelayerResult>> map = new HashMap<>();
        Collection<OnelayerResult> results = personService.getPersonRelation("123",8.0f,8.1f);
        List<OnelayerResult> relationList = new ArrayList<>();
        Iterator<OnelayerResult> iterator = results.iterator();
        while (iterator.hasNext()) {
            relationList.add(iterator.next());
        }
        map.put("ss",relationList);
        return map;
    }

    @RequestMapping("/savePerson")
    public Map<String,String> savePerson(){
        Map<String,String> map = new HashMap<>();
        Person person = new Person("11111","testName","121212","重点人");
        Person endPerson = new Person("11122","endPersonName","121213","重点人");
        Relation relation = new Relation();
        relation.setName("测试");
        relation.setStartPerson(person);
        relation.setPerson(endPerson);
//        List<Relation> relationList = new ArrayList<>();
//        relationList.add(relation);
//        person.setRelations(relationList);
        personService.savePerson(person);
        return map;
    }


    @RequestMapping("/updatePerson")
    public Map<String,String> updatePerson(){
        Map<String,String> map = new HashMap<>();
        Person person = personService.getPersonByIdnumber("11111");
//        Relation relation = person.getRelations().get(0);
//        relation.setCode("G2323");
        person.setName(person.getName()+" !");
        personService.savePerson(person);
        return map;
    }


    @RequestMapping("/getPersonRelationGraph")
    public Map<String,Set<Graph>> getRelationGraph(
            @RequestBody RequestPara requestPara
//            @RequestParam(value = "idnumber") String[] idnumber,
//            @RequestParam(value = "personStrength") Float[] personStrength,
//            @RequestParam(value = "groupStrength") Float[] groupStrength,
//            @RequestParam(value = "classStrength") Float[] classStrenth,
//            @RequestParam(value = "basicStrength") Float[] basicStrenth,
//            @RequestParam(value = "limit", required = false) Integer limit
    ){

        Set<Graph> nodeList = new HashSet<>();
        Set<Graph> edgeList = new HashSet<>();
        Float[] personStrength = requestPara.getPersonStrength();
        Float[] groupStrength = requestPara.getGroupStrength();
        Float[] classStrenth = requestPara.getClassStrength();
        Float[] basicStrenth = requestPara.getBasicStrength();
        for (String id:requestPara.getIdnumber()){
            Collection<NodeEdge> personCollection = personService.getPersonRelationNet(id,personStrength[0],personStrength[1]);
            Collection<NodeEdge> groupCollecion = personService.getGroupRelationNet(id,groupStrength[0],groupStrength[1]);
            Collection<NodeEdge> classCollection = personService.getClassRelationNet(id,classStrenth[0],classStrenth[1]);
            Collection<NodeEdge> basicCollection = personService.getBasicRelationNet(id,basicStrenth[0],basicStrenth[1]);
            assembleData(nodeList,edgeList,personCollection.iterator());
            assembleData(nodeList,edgeList,groupCollecion.iterator());
            assembleData(nodeList,edgeList,classCollection.iterator());
            assembleData(nodeList,edgeList,basicCollection.iterator());
            Node node = personService.getNodeById(id);
            nodeList.add(node);
        }



        Map<String,Set<Graph>> map = new HashMap<>();
        map.put("nodes",nodeList);
        map.put("edges",edgeList);

        return map;
    }

    private void assembleData(Set<Graph> nodeList,Set<Graph> edgeList,Iterator<NodeEdge> iterator){
        while (iterator.hasNext()){
            NodeEdge nodeEdge = iterator.next();
            nodeList.add (new Node(nodeEdge.getIdnumber(),nodeEdge.getAlias(),nodeEdge.getName(),
                    nodeEdge.getKeynumber(), nodeEdge.getLabels()));
            edgeList.add(new Edge(nodeEdge.getFrom(),nodeEdge.getTo(),nodeEdge.getStrength(),
                    nodeEdge.getCode(),nodeEdge.getDetail(),nodeEdge.getId(),
                    nodeEdge.getRname(),nodeEdge.getRtype()));

        }
    }

}
