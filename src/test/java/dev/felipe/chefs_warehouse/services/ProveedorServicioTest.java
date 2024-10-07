package dev.felipe.chefs_warehouse.services;

import dev.felipe.chefs_warehouse.models.Proveedor;
import dev.felipe.chefs_warehouse.repositories.ProveedorRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProveedorServicioTest {

    @Mock
    private ProveedorRepositorio proveedorRepositorio;

    @InjectMocks
    private ProveedorServicio proveedorServicio;

    private Proveedor proveedor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        proveedor = new Proveedor();
        proveedor.setId(1L);
        proveedor.setNombre("Proveedor Test");
        proveedor.setCategoria("Lácteos");
    }

    @Test
    public void testObtenerTodosLosProveedores() {
        List<Proveedor> proveedores = new ArrayList<>();
        proveedores.add(proveedor);

        when(proveedorRepositorio.findAll()).thenReturn(proveedores);

        List<Proveedor> result = proveedorServicio.obtenerTodosLosProveedores();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Proveedor Test", result.get(0).getNombre());
    }

    @Test
    public void testObtenerProveedorPorId() {
        when(proveedorRepositorio.findById(1L)).thenReturn(Optional.of(proveedor));

        Optional<Proveedor> result = proveedorServicio.obtenerProveedorPorId(1L);

        assertTrue(result.isPresent());
        assertEquals("Proveedor Test", result.get().getNombre());
    }

    @Test
    public void testGuardarProveedor() {
        when(proveedorRepositorio.save(any(Proveedor.class))).thenReturn(proveedor);

        Proveedor result = proveedorServicio.guardarProveedor(proveedor);

        assertNotNull(result);
        assertEquals("Proveedor Test", result.getNombre());
        verify(proveedorRepositorio, times(1)).save(proveedor);
    }

    @Test
    public void testEliminarProveedor() {
        doNothing().when(proveedorRepositorio).deleteById(1L);

        assertDoesNotThrow(() -> proveedorServicio.eliminarProveedor(1L));

        verify(proveedorRepositorio, times(1)).deleteById(1L);
    }

    @Test
    public void testObtenerCategorias() {
        List<String> categorias = proveedorServicio.obtenerCategorias();

        assertNotNull(categorias);
        assertEquals(6, categorias.size());
        assertTrue(categorias.contains("Lácteos"));
        assertTrue(categorias.contains("Carnes"));
        assertTrue(categorias.contains("Vegetales"));
        assertTrue(categorias.contains("Pescado"));
        assertTrue(categorias.contains("Quesos"));
        assertTrue(categorias.contains("mariscos"));
    }
}
