package com.ieven.repository;

import com.ieven.domain.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author pdtyreus
 * @author Mark Angrish
 */
@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    Person findByName(@Param("name") String name);

//    Person findByIdnumber(@Param("idnumber")String idnumber);
}
