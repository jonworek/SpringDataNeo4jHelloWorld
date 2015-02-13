package com.jonathanworek.helloworld.neo4j.controllers;

import com.jonathanworek.helloworld.neo4j.dao.MovieRepository;
import com.jonathanworek.helloworld.neo4j.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by jworek on 2/12/15.
 */
@RestController
@Transactional
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    MovieRepository movieRepo;

    @RequestMapping(name = "/", method = GET)
    public Iterable<Movie> allMovies() {
        Iterable<Movie> result = movieRepo.findAll();
        return result;
    }

    @RequestMapping("/{id}")
    public Movie findMovieById(@PathVariable Long id) {
        Movie result = movieRepo.findOne(id);
        return result;
    }

    @RequestMapping(name = "/", method = POST)
    public Movie createMovie(@RequestParam String title) {
        Movie m = new Movie(title);

        Movie createdMovie = movieRepo.save(m);
        return createdMovie;
    }
}
