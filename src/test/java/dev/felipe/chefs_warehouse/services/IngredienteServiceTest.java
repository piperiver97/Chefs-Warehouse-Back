package dev.felipe.chefs_warehouse.services;

import dev.felipe.chefs_warehouse.models.Ingrediente;
import dev.felipe.chefs_warehouse.repositories.IngredienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class IngredienteServiceTest {

    @Mock
    private IngredienteRepository ingredienteRepository;

    @InjectMocks
    private IngredienteService ingredienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerTodosLosIngredientes() {
        Ingrediente ingrediente1 = new Ingrediente("Tomate", "Frío", LocalDate.now(), 5, 0, 0);
        Ingrediente ingrediente2 = new Ingrediente("Cebolla", "Seco", LocalDate.now().plusDays(5), 0, 500, 0);
        List<Ingrediente> ingredientes = Arrays.asList(ingrediente1, ingrediente2);

        when(ingredienteRepository.findAll()).thenReturn(ingredientes);

        List<Ingrediente> result = ingredienteService.obtenerTodosLosIngredientes();

        assertEquals(2, result.size());
        assertEquals("Tomate", result.get(0).getNombre());
        assertEquals("Cebolla", result.get(1).getNombre());
    }

    @Test
    void testObtenerIngredientePorId() {
        Long id = 1L;
        Ingrediente ingrediente = new Ingrediente("Tomate", "Frío", LocalDate.now(), 5, 0, 0);
        when(ingredienteRepository.findById(id)).thenReturn(Optional.of(ingrediente));

        Ingrediente result = ingredienteService.obtenerIngredientePorId(id);

        assertNotNull(result);
        assertEquals("Tomate", result.getNombre());
        verify(ingredienteRepository).findById(id);
    }

    @Test
    void testGuardarIngrediente() {
        // Arrange
        Ingrediente ingrediente = new Ingrediente("Tomate", "Frío", LocalDate.now(), 5, 0, 0);
        when(ingredienteRepository.save(any(Ingrediente.class))).thenReturn(ingrediente);

        // Act
        Ingrediente result = ingredienteService.guardarIngrediente(ingrediente);

        // Assert
        assertNotNull(result);
        assertEquals("Tomate", result.getNombre());
        verify(ingredienteRepository).save(ingrediente);
    }

    @Test
    void testActualizarIngrediente() {
        // Arrange
        Long id = 1L;
        Ingrediente ingrediente = new Ingrediente("Tomate", "Frío", LocalDate.now(), 5, 0, 0);
        when(ingredienteRepository.existsById(id)).thenReturn(true);
        when(ingredienteRepository.save(any(Ingrediente.class))).thenReturn(ingrediente);

        // Act
        Ingrediente result = ingredienteService.actualizarIngrediente(id, ingrediente);

        // Assert
        assertNotNull(result);
        assertEquals("Tomate", result.getNombre());
        verify(ingredienteRepository).save(ingrediente);
    }

    @Test
    void testActualizarIngredienteNoExistente() {
        // Arrange
        Long id = 1L;
        Ingrediente ingrediente = new Ingrediente("Tomate", "Frío", LocalDate.now(), 5, 0, 0);
        when(ingredienteRepository.existsById(id)).thenReturn(false);

        // Act
        Ingrediente result = ingredienteService.actualizarIngrediente(id, ingrediente);

        // Assert
        assertNull(result);
        verify(ingredienteRepository, never()).save(any());
    }

    @Test
    void testEliminarIngrediente() {
        // Arrange
        Long id = 1L;
        when(ingredienteRepository.existsById(id)).thenReturn(true);

        // Act
        boolean result = ingredienteService.eliminarIngrediente(id);

        // Assert
        assertTrue(result);
        verify(ingredienteRepository).deleteById(id);
    }

    @Test
    void testEliminarIngredienteNoExistente() {
        // Arrange
        Long id = 1L;
        when(ingredienteRepository.existsById(id)).thenReturn(false);

        // Act
        boolean result = ingredienteService.eliminarIngrediente(id);

        // Assert
        assertFalse(result);
        verify(ingredienteRepository, never()).deleteById(id);
    }

    @Test
    void testObtenerIngredientesPorCategoria() {
        // Arrange
        String categoria = "Verdura";
        Ingrediente ingrediente = new Ingrediente("Tomate", "Frío", LocalDate.now(), 5, 0, 0);
        when(ingredienteRepository.findByCategoria(categoria)).thenReturn(Arrays.asList(ingrediente));

        // Act
        List<Ingrediente> result = ingredienteService.obtenerIngredientesPorCategoria(categoria);

        // Assert
        assertEquals(1, result.size());
        assertEquals("Tomate", result.get(0).getNombre());
    }

    @Test
    void testObtenerIngredientesPorAlmacenamiento() {
        // Arrange
        String almacenamiento = "Frío";
        Ingrediente ingrediente = new Ingrediente("Tomate", "Frío", LocalDate.now(), 5, 0, 0);
        when(ingredienteRepository.findByAlmacenamiento(almacenamiento)).thenReturn(Arrays.asList(ingrediente));

        // Act
        List<Ingrediente> result = ingredienteService.obtenerIngredientesPorAlmacenamiento(almacenamiento);

        // Assert
        assertEquals(1, result.size());
        assertEquals("Tomate", result.get(0).getNombre());
    }

    @Test
    void testObtenerIngredientesPorFechaCaducidad() {
        // Arrange
        LocalDate fechaCaducidad = LocalDate.now();
        Ingrediente ingrediente = new Ingrediente("Tomate", "Frío", fechaCaducidad, 5, 0, 0);
        when(ingredienteRepository.findByFechaDeCaducidad(fechaCaducidad)).thenReturn(Arrays.asList(ingrediente));

        // Act
        List<Ingrediente> result = ingredienteService.obtenerIngredientesPorFechaCaducidad(fechaCaducidad);

        // Assert
        assertEquals(1, result.size());
        assertEquals("Tomate", result.get(0).getNombre());
    }

    @Test
    void testObtenerIngredientesPorCantidad() {
        // Arrange
        Integer cantidadKilos = 5;
        Integer cantidadGramos = 0;
        Integer cantidadUnidades = 0;
        Ingrediente ingrediente = new Ingrediente("Tomate", "Frío", LocalDate.now(), cantidadKilos, cantidadGramos, cantidadUnidades);
        when(ingredienteRepository.findByCantidadKilosAndCantidadGramosAndCantidadUnidades(cantidadKilos, cantidadGramos, cantidadUnidades))
                .thenReturn(Arrays.asList(ingrediente));

        // Act
        List<Ingrediente> result = ingredienteService.obtenerIngredientesPorCantidad(cantidadKilos, cantidadGramos, cantidadUnidades);

        // Assert
        assertEquals(1, result.size());
        assertEquals("Tomate", result.get(0).getNombre());
    }

    @Test
    void testFiltrarIngredientes() {
        // Arrange
        Ingrediente ingrediente1 = new Ingrediente("Tomate", "Frío", LocalDate.now(), 5, 0, 0);
        Ingrediente ingrediente2 = new Ingrediente("Cebolla", "Seco", LocalDate.now().plusDays(5), 0, 500, 0);
        List<Ingrediente> ingredientes = Arrays.asList(ingrediente1, ingrediente2);
        
        when(ingredienteRepository.filtrarIngredientes(any(), any(), any(), any())).thenReturn(ingredientes);

        // Act
        List<Ingrediente> result = ingredienteService.filtrarIngredientes(null, null, null, null);

        // Assert
        assertEquals(2, result.size());
        assertEquals("Tomate", result.get(0).getNombre());
        assertEquals("Cebolla", result.get(1).getNombre());
    }
}
