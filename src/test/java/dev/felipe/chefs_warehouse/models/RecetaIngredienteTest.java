package dev.felipe.chefs_warehouse.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RecetaIngredienteTest {

    @Test
    void testGetCantidad() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        recetaIngrediente.setCantidad(2.5f);
        assertEquals(2.5f, recetaIngrediente.getCantidad());
    }

    @Test
    void testGetUnidadMedida() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        recetaIngrediente.setUnidadMedida("gramos");
        assertEquals("gramos", recetaIngrediente.getUnidadMedida());
    }

    @Test
    void testGetReceta() {
        Receta receta = new Receta();
        receta.setId(1L);
        
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        recetaIngrediente.setReceta(receta);
        
        assertEquals(receta, recetaIngrediente.getReceta());
    }

    @Test
    void testGetIngrediente() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setId(1L);
        
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        recetaIngrediente.setIngrediente(ingrediente);
        
        assertEquals(ingrediente, recetaIngrediente.getIngrediente());
    }

    @Test
    void testSetCantidad() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        recetaIngrediente.setCantidad(5.0f);
        assertEquals(5.0f, recetaIngrediente.getCantidad());
    }

    @Test
    void testSetUnidadMedida() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        recetaIngrediente.setUnidadMedida("litros");
        assertEquals("litros", recetaIngrediente.getUnidadMedida());
    }

    @Test
    void testSetReceta() {
        Receta receta = new Receta();
        receta.setId(2L);
        
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        recetaIngrediente.setReceta(receta);
        
        assertEquals(receta, recetaIngrediente.getReceta());
    }

    @Test
    void testSetIngrediente() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setId(2L);
        
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        recetaIngrediente.setIngrediente(ingrediente);
        
        assertEquals(ingrediente, recetaIngrediente.getIngrediente());
    }
}
