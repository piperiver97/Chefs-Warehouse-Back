package dev.felipe.chefs_warehouse.repositories;

import dev.felipe.chefs_warehouse.models.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long> {
}