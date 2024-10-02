package dev.felipe.chefs_warehouse.repositories;

import dev.felipe.chefs_warehouse.models.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

    // Método para encontrar ingredientes por categoría
    List<Ingrediente> findByCategoria(String categoria);
}
