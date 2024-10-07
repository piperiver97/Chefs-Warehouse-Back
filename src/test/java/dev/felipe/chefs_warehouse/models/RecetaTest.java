package dev.felipe.chefs_warehouse.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class RecetaTest {

    @Test
    void testCanEqual() {
        Receta receta1 = new Receta();
        Receta receta2 = new Receta();
        assertTrue(receta1.canEqual(receta2));
    }

    @Test
    void testEquals() {
        Receta receta1 = new Receta();
        receta1.setId(1L);
        Receta receta2 = new Receta();
        receta2.setId(1L);
        assertTrue(receta1.equals(receta2));
    }

    @Test
    void testGetDificultad() {
        Receta receta = new Receta();
        receta.setDificultad("Fácil");
        assertEquals("Fácil", receta.getDificultad());
    }

    @Test
    void testGetElaboracion() {
        Receta receta = new Receta();
        receta.setElaboracion("Mezclar todos los ingredientes.");
        assertEquals("Mezclar todos los ingredientes.", receta.getElaboracion());
    }

    @Test
    void testGetId() {
        Receta receta = new Receta();
        receta.setId(1L);
        assertEquals(1L, receta.getId());
    }

    @Test
    void testGetImagen() {
        Receta receta = new Receta();
        receta.setImagen("receta.jpg");
        assertEquals("receta.jpg", receta.getImagen());
    }

    

    @Test
    void testGetNombre() {
        Receta receta = new Receta();
        receta.setNombre("Pan");
        assertEquals("Pan", receta.getNombre());
    }

    @Test
    void testGetPorciones() {
        Receta receta = new Receta();
        receta.setPorciones(4);
        assertEquals(4, receta.getPorciones());
    }

    @Test
    void testGetTecnicasCocina() {
        Receta receta = new Receta();
        receta.setTecnicasCocina("Hornear, Mezclar"); // Ajustar a String
        assertEquals("Hornear, Mezclar", receta.getTecnicasCocina());
    }

    @Test
    void testGetTiempoCoccion() {
        Receta receta = new Receta();
        receta.setTiempoCoccion(30);
        assertEquals(30, receta.getTiempoCoccion());
    }

    @Test
    void testGetTiempoPreparacion() {
        Receta receta = new Receta();
        receta.setTiempoPreparacion(15);
        assertEquals(15, receta.getTiempoPreparacion());
    }

   

    @Test
    void testSetDificultad() {
        Receta receta = new Receta();
        receta.setDificultad("Difícil");
        assertEquals("Difícil", receta.getDificultad());
    }

    @Test
    void testSetElaboracion() {
        Receta receta = new Receta();
        receta.setElaboracion("Hornear a 180°C.");
        assertEquals("Hornear a 180°C.", receta.getElaboracion());
    }

    @Test
    void testSetId() {
        Receta receta = new Receta();
        receta.setId(2L);
        assertEquals(2L, receta.getId());
    }

    @Test
    void testSetImagen() {
        Receta receta = new Receta();
        receta.setImagen("ensalada.jpg");
        assertEquals("ensalada.jpg", receta.getImagen());
    }


    @Test
    void testSetNombre() {
        Receta receta = new Receta();
        receta.setNombre("Ensalada");
        assertEquals("Ensalada", receta.getNombre());
    }

    @Test
    void testSetPorciones() {
        Receta receta = new Receta();
        receta.setPorciones(2);
        assertEquals(2, receta.getPorciones());
    }

    @Test
    void testSetTecnicasCocina() {
        Receta receta = new Receta();
        receta.setTecnicasCocina("Cocinar al vapor"); // Ajustar a String
        assertEquals("Cocinar al vapor", receta.getTecnicasCocina());
    }

    @Test
    void testSetTiempoCoccion() {
        Receta receta = new Receta();
        receta.setTiempoCoccion(45);
        assertEquals(45, receta.getTiempoCoccion());
    }

    @Test
    void testSetTiempoPreparacion() {
        Receta receta = new Receta();
        receta.setTiempoPreparacion(10);
        assertEquals(10, receta.getTiempoPreparacion());
    }

  
}
