package com.ieven.services;

import com.ieven.domain.Person;
import com.ieven.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangdechang on 2018/1/23
 */
@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public Person getPerson(String name){
        return personRepository.findByName(name);
    }

//    public Person getPersonByIdnumber(String idnumber){
//        return personRepository.findByIdnumber(idnumber);
//    }
}
