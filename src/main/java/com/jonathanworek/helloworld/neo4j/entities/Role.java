package com.jonathanworek.helloworld.neo4j.entities;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * Created by jworek on 2/13/15.
 */
@RelationshipEntity(type = "ACTS_IN")
public class Role extends AbstractEntity {
    @StartNode
    Person actor;

    @EndNode
    Movie movie;

    String role;

    public Role() {

    }

    public Role(Person actor, Movie movie, String role) {
        this.actor = actor;
        this.movie = movie;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String value) {
        this.role = value;
    }
}
