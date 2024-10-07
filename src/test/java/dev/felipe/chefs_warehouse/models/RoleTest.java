package dev.felipe.chefs_warehouse.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RoleTest {

    @Test
    void testGetId() {
        Role role = new Role();
        role.setId(1L);
        assertEquals(1L, role.getId());
    }

    @Test
    void testGetName() {
        Role role = new Role();
        role.setName("ADMIN");
        assertEquals("ADMIN", role.getName());
    }


    @Test
    void testSetId() {
        Role role = new Role();
        role.setId(2L);
        assertEquals(2L, role.getId());
    }

    @Test
    void testSetName() {
        Role role = new Role();
        role.setName("USER");
        assertEquals("USER", role.getName());
    }

  

    @Test
    void testEquals() {
        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("ADMIN");

        Role role2 = new Role();
        role2.setId(1L);
        role2.setName("ADMIN");

        assertEquals(role1, role2);
    }

   

    @Test
    void testCanEqual() {
        Role role1 = new Role();
        Role role2 = new Role();

        assertTrue(role1.canEqual(role2));
    }

    
}
