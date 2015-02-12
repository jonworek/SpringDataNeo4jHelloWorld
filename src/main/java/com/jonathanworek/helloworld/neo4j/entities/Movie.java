package com.jonathanworek.helloworld.neo4j.entities;

import org.springframework.data.neo4j.annotation.*;

import java.util.Set;

import static org.neo4j.graphdb.Direction.*;
import static org.springframework.data.neo4j.support.index.IndexType.*;

/**
 * Created by jworek on 2/12/15.
 */
@NodeEntity
public class Movie {

    @GraphId
    Long id;

    @Indexed(indexType = FULLTEXT, indexName = "search")
    String title;

    Person director;

    @RelatedTo(type = "ACTS_IN", direction = INCOMING)
    Set<Person> actors;

    @RelatedToVia(type = "RATED")
    Iterable<Rating> ratings;

    @Query("START movie-node({self})" +
            "MATCH movie-->genre<--similar" +
            "RETURN similar")
    Iterable<Movie> similarMovies;
}
