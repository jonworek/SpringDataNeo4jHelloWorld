package com.jonathanworek.helloworld.neo4j.dao;

import com.jonathanworek.helloworld.neo4j.entities.Person;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by jworek on 2/13/15.
 */
public interface PersonRepository extends GraphRepository<Person> {
}
