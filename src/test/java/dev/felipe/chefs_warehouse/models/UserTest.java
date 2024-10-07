package dev.felipe.chefs_warehouse.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void testGetId() {
        User user = new User();
        user.setId(1L);
        assertEquals(1L, user.getId());
    }

    @Test
    void testGetUsername() {
        User user = new User();
        user.setUsername("testUser");
        assertEquals("testUser", user.getUsername());
    }

    @Test
    void testGetPassword() {
        User user = new User();
        user.setPassword("testPassword");
        assertEquals("testPassword", user.getPassword());
    }

   

    @Test
    void testSetId() {
        User user = new User();
        user.setId(1L);
        assertEquals(1L, user.getId());
    }

    @Test
    void testSetUsername() {
        User user = new User();
        user.setUsername("testUser");
        assertEquals("testUser", user.getUsername());
    }

    @Test
    void testSetPassword() {
        User user = new User();
        user.setPassword("testPassword");
        assertEquals("testPassword", user.getPassword());
    }

    
}
