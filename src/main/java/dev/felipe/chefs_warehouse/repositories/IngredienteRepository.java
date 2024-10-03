package dev.felipe.chefs_warehouse.repositories;

import dev.felipe.chefs_warehouse.models.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
    List<Ingrediente> findByCategoria(String categoria);
    List<Ingrediente> findByAlmacenamiento(String almacenamiento);
    List<Ingrediente> findByFechaDeCaducidad(LocalDate fechaDeCaducidad);
    List<Ingrediente> findByKilosAndGramosAndUnidades(int kilos, int gramos, int unidades);
}
