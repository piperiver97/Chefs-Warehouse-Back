package dev.felipe.chefs_warehouse.services;

import dev.felipe.chefs_warehouse.facades.encryptations.Base64Encoder;
import  dev.felipe.chefs_warehouse.models.Role;
import  dev.felipe.chefs_warehouse.models.User;
import  dev.felipe.chefs_warehouse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;  // Cambiar aquí al paquete correcto
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Base64Encoder base64Encoder;

    public void createSalesman(String username, String encryptedPassword) {
        Role salesmanRole = roleService.findByName("ROLE_SALESMAN");

        if (salesmanRole == null) {
            throw new IllegalArgumentException("Role not found");
        }

        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        String decryptedPassword = base64Encoder.decode(encryptedPassword);

        User user = new User(username, decryptedPassword);
        user.setRoles(Collections.singleton(salesmanRole));

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<User> getAllSalesmen() {
        return userRepository.findAll();
    }
}
