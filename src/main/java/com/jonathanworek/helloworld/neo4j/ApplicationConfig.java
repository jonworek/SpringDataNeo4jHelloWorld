package com.jonathanworek.helloworld.neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;

/**
 * Created by jworek on 2/12/15.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableNeo4jRepositories({
        "com.jonathanworek.helloworld.neo4j.entities",
        "com.jonathanworek.helloworld.neo4j.dao"
})
public class ApplicationConfig extends Neo4jConfiguration {
    @Autowired
    GraphDatabase graphDatabase;

    public ApplicationConfig() {
        setBasePackage("com.jonathanworek.helloworld.neo4j");
    }

    @Bean
    GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("target/graph.db");

        // connect to the local instance
        //return new SpringRestGraphDatabase("http://localhost:7474/db/data/");
    }
}
