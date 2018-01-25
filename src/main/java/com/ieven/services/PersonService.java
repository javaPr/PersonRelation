package com.ieven.services;

import com.ieven.domain.OneLayerRelationResult;
import com.ieven.domain.Person;
import com.ieven.domain.Relation;
import com.ieven.domain.OnelayerResult;
import com.ieven.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by wangdechang on 2018/1/23
 */
@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public Person getPersonByName(String name) {
        return personRepository.findByName(name);
    }

    public Person getPersonByIdnumber(String idnumber) {
        return personRepository.findByIdnumber(idnumber);
    }

    public Collection<Person> getPersonRelation(String idnumber) {
        Collection<Person> people = personRepository.getPerson(idnumber);
        return people;
    }

    public Collection<Relation> getRelation(String idnumber) {
        Collection<Relation> people = personRepository.getRelation(idnumber);
        return people;
    }

    public Collection<OnelayerResult> getOneLayer(String idnumber){
        Collection<OnelayerResult> results = personRepository.getOneLayer(idnumber);
        return results;
    }

    public Collection<OneLayerRelationResult> getOneLayerRelation(String idnumber,int limit){
        return personRepository.getOneLayerRelation(idnumber,limit);
    }

    @Transactional
    public void savePerson(Person person){
        personRepository.save(person);
    }

//    public void updatePerson(Person person){
//        personRepository.
//    }
}

