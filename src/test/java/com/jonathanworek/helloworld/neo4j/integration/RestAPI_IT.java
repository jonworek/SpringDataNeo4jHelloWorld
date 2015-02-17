package com.jonathanworek.helloworld.neo4j.integration;

import com.jonathanworek.helloworld.neo4j.TestConfig;
import com.jonathanworek.helloworld.neo4j.dao.MovieRepository;
import com.jonathanworek.helloworld.neo4j.entities.Movie;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static com.jayway.jsonpath.JsonPath.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@WebAppConfiguration
public class RestAPI_IT {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MovieRepository movieRepo;  //todo: fix intellij bitching about autowire

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getFoo_NotFound() throws Exception {
        mockMvc.perform(get("/foo")).
                andExpect(status().isNotFound());
    }

    @Test
    public void getAllMovies_EmptyDatabase() throws Exception {
        mockMvc.perform(get("/movies")).
                andExpect(status().isOk());
    }

    @Test
    public void getAllMovies_OneMovie() throws Exception {
        Movie movie = new Movie("Billy Madison");
        movieRepo.save(movie);

        mockMvc.perform(get("/movies")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.content[0].title").value("Billy Madison"));
    }

    @Test
    public void getAllActors_EmptyDatabase() throws Exception {
        mockMvc.perform(get("/actors")).
                andExpect(status().isOk());
    }
}