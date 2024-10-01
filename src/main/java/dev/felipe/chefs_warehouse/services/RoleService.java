package dev.felipe.chefs_warehouse.services;

import dev.felipe.chefs_warehouse.models.Role;
import dev.felipe.chefs_warehouse.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findByName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}
