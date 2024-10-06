package dev.felipe.chefs_warehouse.repositories;

import dev.felipe.chefs_warehouse.models.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
    
    // Métodos de consulta adicionales
    List<Ingrediente> findByCategoria(String categoria);
    List<Ingrediente> findByAlmacenamiento(String almacenamiento);
    List<Ingrediente> findByFechaDeCaducidad(LocalDate fechaDeCaducidad);
    List<Ingrediente> findByCantidadKilosAndCantidadGramosAndCantidadUnidades(
        Integer cantidadKilos, Integer cantidadGramos, Integer cantidadUnidades);

    @Query("SELECT i FROM Ingrediente i WHERE " +
           "(:nombre IS NULL OR LOWER(i.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) AND " +
           "(:almacenamiento IS NULL OR i.almacenamiento = :almacenamiento) AND " +
           "(:fechaCaducidad IS NULL OR i.fechaDeCaducidad <= :fechaCaducidad) AND " +
           "(:tipoMedida IS NULL OR " +
           "(:tipoMedida = 'KILOS' AND i.cantidadKilos > 0) OR " +
           "(:tipoMedida = 'GRAMOS' AND i.cantidadGramos > 0) OR " +
           "(:tipoMedida = 'UNIDADES' AND i.cantidadUnidades > 0))")
    List<Ingrediente> filtrarIngredientes(
        @Param("nombre") String nombre,
        @Param("almacenamiento") String almacenamiento,
        @Param("fechaCaducidad") LocalDate fechaCaducidad,
        @Param("tipoMedida") String tipoMedida
    );
}
