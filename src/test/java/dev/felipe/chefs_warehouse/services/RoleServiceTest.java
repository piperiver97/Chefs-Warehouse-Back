package dev.felipe.chefs_warehouse.services;

import dev.felipe.chefs_warehouse.models.Role;
import dev.felipe.chefs_warehouse.repositories.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    private Role role;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        role = new Role();
        role.setId(1L);
        role.setName("ROLE_USER");
    }

    @Test
    public void testFindByName() {
        // Arrange
        when(roleRepository.findByName("ROLE_USER")).thenReturn(role);

        // Act
        Role result = roleService.findByName("ROLE_USER");

        // Assert
        assertNotNull(result);
        assertEquals("ROLE_USER", result.getName());
        verify(roleRepository, times(1)).findByName("ROLE_USER");
    }

    @Test
    public void testFindByName_NotFound() {
        // Arrange
        when(roleRepository.findByName("ROLE_ADMIN")).thenReturn(null);

        // Act
        Role result = roleService.findByName("ROLE_ADMIN");

        // Assert
        assertNull(result);
        verify(roleRepository, times(1)).findByName("ROLE_ADMIN");
    }
}
