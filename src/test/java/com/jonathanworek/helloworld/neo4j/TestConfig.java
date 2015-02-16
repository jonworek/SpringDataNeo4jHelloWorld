package com.jonathanworek.helloworld.neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.springframework.context.annotation.AdviceMode.PROXY;

/**
 * Created by jworek on 2/16/15.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableTransactionManagement(mode = PROXY)
@EnableNeo4jRepositories({
        "com.jonathanworek.helloworld.neo4j.entities",
        "com.jonathanworek.helloworld.neo4j.dao"})
public class TestConfig extends Neo4jConfiguration{
    public TestConfig() {
        setBasePackage("com.jonathanworek.helloworld.neo4j");
    }

    @Bean
    GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("target/graph.db");
    }
}
