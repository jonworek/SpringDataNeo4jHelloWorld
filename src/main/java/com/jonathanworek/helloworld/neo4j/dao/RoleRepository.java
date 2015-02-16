package com.jonathanworek.helloworld.neo4j.dao;

import com.jonathanworek.helloworld.neo4j.entities.Movie;
import com.jonathanworek.helloworld.neo4j.entities.Role;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by jworek on 2/12/15.
 */
public interface RoleRepository extends GraphRepository<Role> {

}
