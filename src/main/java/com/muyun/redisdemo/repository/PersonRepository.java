package com.muyun.redisdemo.repository;

import com.muyun.redisdemo.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
