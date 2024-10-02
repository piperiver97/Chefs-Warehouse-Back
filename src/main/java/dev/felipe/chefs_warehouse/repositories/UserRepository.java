package dev.felipe.chefs_warehouse.repositories;

import java.util.List;
import java.util.Optional;

import dev.felipe.chefs_warehouse.models.Role;
import dev.felipe.chefs_warehouse.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    List<User> findByRolesIn(List<Role> role);
}
