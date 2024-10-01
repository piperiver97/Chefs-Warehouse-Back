package dev.felipe.chefs_warehouse.repositories;

import dev.felipe.chefs_warehouse.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
