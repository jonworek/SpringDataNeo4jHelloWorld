package com.jonathanworek.helloworld.neo4j.dao;

import com.jonathanworek.helloworld.neo4j.entities.*;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jworek on 2/12/15.
 */
public interface MovieRepository extends GraphRepository<Movie> {

}
