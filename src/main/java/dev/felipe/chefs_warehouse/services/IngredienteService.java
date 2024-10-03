package dev.felipe.chefs_warehouse.services;

import dev.felipe.chefs_warehouse.models.Ingrediente;
import dev.felipe.chefs_warehouse.repositories.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    // Obtener todos los ingredientes
    public List<Ingrediente> obtenerTodosLosIngredientes() {
        return ingredienteRepository.findAll();
    }

    // Obtener ingrediente por ID
    public Ingrediente obtenerIngredientePorId(Long id) {
        return ingredienteRepository.findById(id).orElse(null);
    }

    // Crear un nuevo ingrediente
    public Ingrediente guardarIngrediente(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    // Actualizar un ingrediente
    public Ingrediente actualizarIngrediente(Long id, Ingrediente ingrediente) {
        if (!ingredienteRepository.existsById(id)) {
            return null;
        }
        ingrediente.setId(id);
        return ingredienteRepository.save(ingrediente);
    }

    // Eliminar un ingrediente
    public boolean eliminarIngrediente(Long id) {
        if (ingredienteRepository.existsById(id)) {
            ingredienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Filtrar ingredientes por categoría
    public List<Ingrediente> obtenerIngredientesPorCategoria(String categoria) {
        return ingredienteRepository.findByCategoria(categoria);
    }

    // Filtrar ingredientes por almacenamiento
    public List<Ingrediente> obtenerIngredientesPorAlmacenamiento(String almacenamiento) {
        return ingredienteRepository.findByAlmacenamiento(almacenamiento);
    }

    // Filtrar ingredientes por fecha de caducidad
    public List<Ingrediente> obtenerIngredientesPorFechaCaducidad(LocalDate fechaCaducidad) {
        return ingredienteRepository.findByFechaDeCaducidad(fechaCaducidad);
    }

    // Filtrar ingredientes por cantidad
    public List<Ingrediente> obtenerIngredientesPorCantidad(
            Integer cantidadKilos, 
            Integer cantidadGramos, 
            Integer cantidadUnidades) {
        return ingredienteRepository.findByCantidadKilosAndCantidadGramosAndCantidadUnidades(
            cantidadKilos, cantidadGramos, cantidadUnidades);
    }
}