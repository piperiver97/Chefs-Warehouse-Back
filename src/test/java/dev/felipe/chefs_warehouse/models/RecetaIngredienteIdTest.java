package dev.felipe.chefs_warehouse.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RecetaIngredienteIdTest {

    @Test
    void testGetIngredienteId() {
        RecetaIngredienteId recetaIngredienteId = new RecetaIngredienteId();
        recetaIngredienteId.setIngredienteId(1L);
        assertEquals(1L, recetaIngredienteId.getIngredienteId());
    }

    @Test
    void testGetRecetaId() {
        RecetaIngredienteId recetaIngredienteId = new RecetaIngredienteId();
        recetaIngredienteId.setRecetaId(2L);
        assertEquals(2L, recetaIngredienteId.getRecetaId());
    }

    @Test
    void testSetIngredienteId() {
        RecetaIngredienteId recetaIngredienteId = new RecetaIngredienteId();
        recetaIngredienteId.setIngredienteId(3L);
        assertEquals(3L, recetaIngredienteId.getIngredienteId());
    }

    @Test
    void testSetRecetaId() {
        RecetaIngredienteId recetaIngredienteId = new RecetaIngredienteId();
        recetaIngredienteId.setRecetaId(4L);
        assertEquals(4L, recetaIngredienteId.getRecetaId());
    }

    @Test
    void testEquals() {
        RecetaIngredienteId id1 = new RecetaIngredienteId();
        id1.setIngredienteId(1L);
        id1.setRecetaId(2L);
        
        RecetaIngredienteId id2 = new RecetaIngredienteId();
        id2.setIngredienteId(1L);
        id2.setRecetaId(2L);
        
        assertEquals(id1, id2);
    }

    @Test
    void testHashCode() {
        RecetaIngredienteId recetaIngredienteId = new RecetaIngredienteId();
        recetaIngredienteId.setIngredienteId(1L);
        recetaIngredienteId.setRecetaId(2L);
        
        int expectedHashCode = Long.hashCode(1L) ^ Long.hashCode(2L);
        assertEquals(expectedHashCode, recetaIngredienteId.hashCode());
    }

    @Test
    void testCanEqual() {
        RecetaIngredienteId id1 = new RecetaIngredienteId();
        RecetaIngredienteId id2 = new RecetaIngredienteId();
        
        assertTrue(id1.canEqual(id2));
    }

    @Test
    void testToString() {
        RecetaIngredienteId recetaIngredienteId = new RecetaIngredienteId();
        recetaIngredienteId.setIngredienteId(1L);
        recetaIngredienteId.setRecetaId(2L);
        
        String expectedString = "RecetaIngredienteId(ingredienteId=1, recetaId=2)";
        assertEquals(expectedString, recetaIngredienteId.toString());
    }
}
