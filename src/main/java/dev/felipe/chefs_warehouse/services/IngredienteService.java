package dev.felipe.chefs_warehouse.services;

import dev.felipe.chefs_warehouse.models.Ingrediente;
import dev.felipe.chefs_warehouse.repositories.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;

    @Autowired
    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public List<Ingrediente> obtenerTodosLosIngredientes() {
        return ingredienteRepository.findAll();
    }

    public Ingrediente obtenerIngredientePorId(Long id) {
        return ingredienteRepository.findById(id).orElse(null);
    }

    public Ingrediente guardarIngrediente(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    public Ingrediente actualizarIngrediente(Long id, Ingrediente ingrediente) {
        if (!ingredienteRepository.existsById(id)) {
            return null;
        }
        ingrediente.setId(id);
        return ingredienteRepository.save(ingrediente);
    }

    public boolean eliminarIngrediente(Long id) {
        if (ingredienteRepository.existsById(id)) {
            ingredienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Ingrediente> obtenerIngredientesPorCategoria(String categoria) {
        return ingredienteRepository.findByCategoria(categoria);
    }

    public List<Ingrediente> obtenerIngredientesPorAlmacenamiento(String almacenamiento) {
        return ingredienteRepository.findByAlmacenamiento(almacenamiento);
    }

    public List<Ingrediente> obtenerIngredientesPorFechaCaducidad(LocalDate fechaCaducidad) {
        return ingredienteRepository.findByFechaDeCaducidad(fechaCaducidad);
    }

    public List<Ingrediente> obtenerIngredientesPorCantidad(
            Integer cantidadKilos, 
            Integer cantidadGramos, 
            Integer cantidadUnidades) {
        return ingredienteRepository.findByCantidadKilosAndCantidadGramosAndCantidadUnidades(
            cantidadKilos, cantidadGramos, cantidadUnidades);
    }
    
    public List<Ingrediente> filtrarIngredientes(String nombre, String almacenamiento, 
                                                LocalDate fechaCaducidad, String tipoMedida) {
        return ingredienteRepository.filtrarIngredientes(
            nombre, almacenamiento, fechaCaducidad, tipoMedida);
    }
}
