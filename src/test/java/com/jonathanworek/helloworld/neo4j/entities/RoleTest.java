package com.jonathanworek.helloworld.neo4j.entities;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jworek on 2/16/15.
 */
public class RoleTest {
    @Test
    public void constructorTest_NoArgs() {
        Role r = new Role();
        assertNotNull(r);
    }
}
