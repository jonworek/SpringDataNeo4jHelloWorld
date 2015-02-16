# SpringDataNeo4jHelloWorld

This is a project to experiment with Spring Data and Neo4j.  It is inspired by the example domain in the Neo4j Spring
  Data Quick Start.  You can find it at http://projects.spring.io/spring-data-neo4j/#quick-start

## Prerequisites
* Maven 3.2+
* Java 1.8

## Rest API

Operations

* Get all movies
    * Route: /movies
    * Method: GET

* Add a movie
    * Route: /movies
    * Method: POST
    * Params:
        * title

* Get details about a movie
    * Route: /movies/{id}
    * Method: GET

* Get actors for a movie
    * Route: /movies/{id}/actors
    * Method: GET

* Add an actor to a movie
    * Route: /movies/{id}/actors
    * Method: POST
    * Params:
        * actorName
        * roleName

* Get all actors
    * Route: /actors
    * Method: GET
