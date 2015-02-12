package com.jonathanworek.helloworld.neo4j.controllers;

import com.jonathanworek.helloworld.neo4j.dao.MovieRepository;
import com.jonathanworek.helloworld.neo4j.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jworek on 2/12/15.
 */
@RestController
public class MoviesController {
    @Autowired
    MovieRepository movieRepo;

    @RequestMapping("/movies")
    public Iterable<Movie> allMovies() {
        return movieRepo.findAll();
    }
}
