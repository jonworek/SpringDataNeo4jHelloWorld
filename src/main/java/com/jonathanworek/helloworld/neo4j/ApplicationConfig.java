package com.jonathanworek.helloworld.neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import org.springframework.data.neo4j.config.*;
import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;
import org.springframework.transaction.annotation.*;

import static org.springframework.context.annotation.AdviceMode.PROXY;

/**
 * Created by jworek on 2/12/15.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableTransactionManagement(mode = PROXY)
@EnableNeo4jRepositories({
        "com.jonathanworek.helloworld.neo4j.entities",
        "com.jonathanworek.helloworld.neo4j.dao"
})
public class ApplicationConfig extends Neo4jConfiguration {
    public ApplicationConfig() {
        setBasePackage("com.jonathanworek.helloworld.neo4j");
    }

    @Bean
    GraphDatabaseService graphDatabaseService() {
        //return new GraphDatabaseFactory().newEmbeddedDatabase("target/graph.db");
        // connect to the local instance
        return new SpringRestGraphDatabase("http://localhost:7474/db/data/");
    }
}
