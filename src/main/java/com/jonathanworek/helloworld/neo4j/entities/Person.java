package com.jonathanworek.helloworld.neo4j.entities;

import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Created by jworek on 2/12/15.
 */
@NodeEntity
public class Person extends AbstractEntity {
    String name;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }
}
