package dev.felipe.chefs_warehouse.models;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class IngredienteTest {

    @Test
    void testGetAlmacenamiento() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setAlmacenamiento("Refrigerado");
        assertEquals("Refrigerado", ingrediente.getAlmacenamiento());
    }

    @Test
    void testGetCantidadGramos() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setCantidadGramos(500);
        assertEquals(500, ingrediente.getCantidadGramos());
    }

    @Test
    void testGetCantidadKilos() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setCantidadKilos(2);
        assertEquals(2, ingrediente.getCantidadKilos());
    }

    @Test
    void testGetCantidadUnidades() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setCantidadUnidades(10);
        assertEquals(10, ingrediente.getCantidadUnidades());
    }

    @Test
    void testGetCategoria() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setCategoria("Vegetal");
        assertEquals("Vegetal", ingrediente.getCategoria());
    }

    @Test
    void testGetFechaDeCaducidad() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setFechaDeCaducidad(LocalDate.of(2024, 12, 31));
        assertEquals(LocalDate.of(2024, 12, 31), ingrediente.getFechaDeCaducidad());
    }

    @Test
    void testGetId() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setId(1L);
        assertEquals(1L, ingrediente.getId());
    }

    @Test
    void testGetImagen() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setImagen("tomate.jpg");
        assertEquals("tomate.jpg", ingrediente.getImagen());
    }

    @Test
    void testGetNombre() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre("Tomate");
        assertEquals("Tomate", ingrediente.getNombre());
    }

    @Test
    void testGetProveedorId() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setProveedorId(1L);
        assertEquals(1L, ingrediente.getProveedorId());
    }

    @Test
    void testSetAlmacenamiento() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setAlmacenamiento("Congelado");
        assertEquals("Congelado", ingrediente.getAlmacenamiento());
    }

    @Test
    void testSetCantidadGramos() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setCantidadGramos(250);
        assertEquals(250, ingrediente.getCantidadGramos());
    }

    @Test
    void testSetCantidadKilos() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setCantidadKilos(5);
        assertEquals(5, ingrediente.getCantidadKilos());
    }

    @Test
    void testSetCantidadUnidades() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setCantidadUnidades(20);
        assertEquals(20, ingrediente.getCantidadUnidades());
    }

    @Test
    void testSetCategoria() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setCategoria("Fruta");
        assertEquals("Fruta", ingrediente.getCategoria());
    }

    @Test
    void testSetFechaDeCaducidad() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setFechaDeCaducidad(LocalDate.of(2024, 11, 30));
        assertEquals(LocalDate.of(2024, 11, 30), ingrediente.getFechaDeCaducidad());
    }

    @Test
    void testSetId() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setId(2L);
        assertEquals(2L, ingrediente.getId());
    }

    @Test
    void testSetImagen() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setImagen("cebolla.jpg");
        assertEquals("cebolla.jpg", ingrediente.getImagen());
    }

    @Test
    void testSetNombre() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre("Cebolla");
        assertEquals("Cebolla", ingrediente.getNombre());
    }

    @Test
    void testSetProveedorId() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setProveedorId(2L);
        assertEquals(2L, ingrediente.getProveedorId());
    }
}
