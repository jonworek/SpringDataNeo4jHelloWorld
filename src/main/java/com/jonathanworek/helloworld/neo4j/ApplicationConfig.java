package com.jonathanworek.helloworld.neo4j;

import com.jonathanworek.helloworld.neo4j.dao.MovieRepository;
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

/**
 * Created by jworek on 2/12/15.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableNeo4jRepositories
public class ApplicationConfig extends Neo4jConfiguration {
    @Autowired
    GraphDatabase graphDatabase;

    @Bean
    GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("target/graph.db");
    }
}
