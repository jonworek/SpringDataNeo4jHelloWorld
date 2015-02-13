package com.jonathanworek.helloworld.neo4j.entities;

import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import java.util.Set;

import static org.neo4j.graphdb.Direction.*;
import static org.springframework.data.neo4j.support.index.IndexType.FULLTEXT;

/**
 * Created by jworek on 2/12/15.
 */
@NodeEntity
public class Person extends AbstractEntity {
    @Indexed
    String name;

    @RelatedTo(type = "ACTS_IN", direction = OUTGOING)
    Set<Movie> movies;

    @RelatedToVia(type = "ACTS_IN")
    Set<Role> roles;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public void actedIn(Movie movie, String roleName) {
        this.roles.add(new Role(this, movie, roleName));
    }
}
