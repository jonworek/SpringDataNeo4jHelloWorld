package com.jonathanworek.helloworld.neo4j.controllers;

import com.jonathanworek.helloworld.neo4j.dao.MovieRepository;
import com.jonathanworek.helloworld.neo4j.dao.PersonRepository;
import com.jonathanworek.helloworld.neo4j.dao.RoleRepository;
import com.jonathanworek.helloworld.neo4j.entities.Movie;
import com.jonathanworek.helloworld.neo4j.entities.Person;
import com.jonathanworek.helloworld.neo4j.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
//@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    MovieRepository movieRepo;

    @Autowired
    PersonRepository personRepo;

    @Autowired
    RoleRepository roleRepo;

    @RequestMapping(value = "/movies", method = GET)
    public Iterable<Movie> allMovies(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

        Iterable<Movie> result = movieRepo.findAll(new PageRequest(page, pageSize));
        return result;
    }

    @RequestMapping(value = "/movies", method = POST)
    public Movie createMovie(@RequestParam String title) {
        Movie m = new Movie(title);

        Movie createdMovie = movieRepo.save(m);
        return createdMovie;
    }

    @RequestMapping(value = "/movies/{id}")
    public Movie findMovieById(@PathVariable Long id) {
        Movie result = movieRepo.findOne(id);
        return result;
    }

    @RequestMapping(value = "/movies/{id}/actors")
    public Iterable<Person> findActorsForMovieById(@PathVariable Long id) {
        Movie result = movieRepo.findOne(id);
        return result.getActors();
    }

    @RequestMapping(value = "/movies/{id}/actors", method = POST)
    public Role addActorToMovie(@PathVariable Long id,
                                @RequestParam String actorName,
                                @RequestParam String roleName) {
        Movie movie = movieRepo.findOne(id);
        Person actor = personRepo.findBySchemaPropertyValue("name", actorName);
        if (actor == null) {
            actor = personRepo.save(new Person(actorName));
        }

        //todo: make this method work so we save the relationship
        Role r = actor.actedIn(movie, roleName);

        roleRepo.save(r);
        //personRepo.save(actor);
        //movieRepo.save(movie);

        return r;
    }
}