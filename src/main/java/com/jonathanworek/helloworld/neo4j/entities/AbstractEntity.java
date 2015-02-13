package com.jonathanworek.helloworld.neo4j.entities;

import org.springframework.data.neo4j.annotation.GraphId;

/**
 * Created by jworek on 2/13/15.
 */
public abstract class AbstractEntity {
    @GraphId
    Long id;

    public Long getId() {
        return id;
    }
}
