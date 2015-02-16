package com.jonathanworek.helloworld.neo4j.integration;

import com.jonathanworek.helloworld.neo4j.TestConfig;
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
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@WebAppConfiguration
public class RestAPI_IT {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

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
    public void getAllActors_EmptyDatabase() throws Exception {
        mockMvc.perform(get("/actors")).
                andExpect(status().isOk());
    }
}