package dev.felipe.chefs_warehouse.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProveedorTest {

    @Test
    void testGetCategoria() {
        Proveedor proveedor = new Proveedor();
        proveedor.setCategoria("Frutas y Verduras");
        assertEquals("Frutas y Verduras", proveedor.getCategoria());
    }

    @Test
    void testGetContacto() {
        Proveedor proveedor = new Proveedor();
        proveedor.setContacto("Juan Pérez");
        assertEquals("Juan Pérez", proveedor.getContacto());
    }

    @Test
    void testGetCorreoElectronico() {
        Proveedor proveedor = new Proveedor();
        proveedor.setCorreoElectronico("juan.perez@ejemplo.com");
        assertEquals("juan.perez@ejemplo.com", proveedor.getCorreoElectronico());
    }

    @Test
    void testGetDireccion() {
        Proveedor proveedor = new Proveedor();
        proveedor.setDireccion("Calle Principal 123");
        assertEquals("Calle Principal 123", proveedor.getDireccion());
    }

    @Test
    void testGetId() {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(1L);
        assertEquals(1L, proveedor.getId());
    }

    @Test
    void testGetNombre() {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre("Proveedor A");
        assertEquals("Proveedor A", proveedor.getNombre());
    }

    @Test
    void testGetTelefono() {
        Proveedor proveedor = new Proveedor();
        proveedor.setTelefono("555-1234");
        assertEquals("555-1234", proveedor.getTelefono());
    }

    @Test
    void testSetCategoria() {
        Proveedor proveedor = new Proveedor();
        proveedor.setCategoria("Lácteos");
        assertEquals("Lácteos", proveedor.getCategoria());
    }

    @Test
    void testSetContacto() {
        Proveedor proveedor = new Proveedor();
        proveedor.setContacto("María Gómez");
        assertEquals("María Gómez", proveedor.getContacto());
    }

    @Test
    void testSetCorreoElectronico() {
        Proveedor proveedor = new Proveedor();
        proveedor.setCorreoElectronico("maria.gomez@ejemplo.com");
        assertEquals("maria.gomez@ejemplo.com", proveedor.getCorreoElectronico());
    }

    @Test
    void testSetDireccion() {
        Proveedor proveedor = new Proveedor();
        proveedor.setDireccion("Avenida Secundaria 456");
        assertEquals("Avenida Secundaria 456", proveedor.getDireccion());
    }

    @Test
    void testSetId() {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(2L);
        assertEquals(2L, proveedor.getId());
    }

    @Test
    void testSetNombre() {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre("Proveedor B");
        assertEquals("Proveedor B", proveedor.getNombre());
    }

    @Test
    void testSetTelefono() {
        Proveedor proveedor = new Proveedor();
        proveedor.setTelefono("555-5678");
        assertEquals("555-5678", proveedor.getTelefono());
    }
}
