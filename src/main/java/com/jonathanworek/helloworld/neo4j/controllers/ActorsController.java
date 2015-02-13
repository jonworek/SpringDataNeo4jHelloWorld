package com.jonathanworek.helloworld.neo4j.controllers;

import com.jonathanworek.helloworld.neo4j.dao.PersonRepository;
import com.jonathanworek.helloworld.neo4j.entities.Movie;
import com.jonathanworek.helloworld.neo4j.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
* Created by jworek on 2/13/15.
*/
@RestController
//@RequestMapping("/actors")
public class ActorsController {

    @Autowired
    PersonRepository personRepo;

    @RequestMapping(value = "/actors", method = GET)
    public Iterable<Person> allActors(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

        Iterable<Person> result = personRepo.findAll(new PageRequest(page, pageSize));
        return result;
    }
}
