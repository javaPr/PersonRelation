package com.ieven.controller;

import com.ieven.domain.Person;
import com.ieven.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mark Angrish
 */
@RestController
public class PersonController {

    final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/getPerson")
    public Map<String, Person> getPerson(@RequestParam(value = "name") String name) {
        System.out.println("=====================");
        Person person = personService.getPerson(name);
        Map<String, Person> map = new HashMap<>();
        map.put("person", person);
        return map;
    }

//    @RequestMapping(value = "/getPersonById")
//    public Map<String, Person> getPersonByIdNumber(@RequestParam(value = "idnumber") String idnumber) {
//        Person person = personService.getPersonByIdnumber(idnumber);
//        Map<String, Person> map = new HashMap<>();
//        map.put("person", person);
//        return map;
//    }


}
