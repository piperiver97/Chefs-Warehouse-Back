package dev.felipe.chefs_warehouse.services;

import dev.felipe.chefs_warehouse.facades.encryptations.Base64Encoder;
import dev.felipe.chefs_warehouse.models.Role;
import dev.felipe.chefs_warehouse.models.User;
import dev.felipe.chefs_warehouse.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleService roleService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private Base64Encoder base64Encoder;

    @InjectMocks
    private UserService userService;

    private Role salesmanRole;
    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize the Role and User objects
        salesmanRole = new Role();
        salesmanRole.setId(1L);
        salesmanRole.setName("ROLE_SALESMAN");

        user = new User("salesman", "password"); // Assuming the User constructor takes these parameters
    }

    @Test
    public void testCreateSalesman_Success() {
        // Arrange
        String encryptedPassword = "cGFzc3dvcmQ="; // Base64 for "password"
        when(roleService.findByName("ROLE_SALESMAN")).thenReturn(salesmanRole);
        when(userRepository.findByUsername("salesman")).thenReturn(Optional.empty());
        when(base64Encoder.decode(encryptedPassword)).thenReturn("password");
        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");

        // Act
        userService.createSalesman("salesman", encryptedPassword);

        // Assert
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testCreateSalesman_RoleNotFound() {
        // Arrange
        String encryptedPassword = "cGFzc3dvcmQ="; // Base64 for "password"
        when(roleService.findByName("ROLE_SALESMAN")).thenReturn(null);

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.createSalesman("salesman", encryptedPassword);
        });
        assertEquals("Role not found", exception.getMessage());
    }

    @Test
    public void testCreateSalesman_UsernameExists() {
        // Arrange
        String encryptedPassword = "cGFzc3dvcmQ="; // Base64 for "password"
        when(roleService.findByName("ROLE_SALESMAN")).thenReturn(salesmanRole);
        when(userRepository.findByUsername("salesman")).thenReturn(Optional.of(user));

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.createSalesman("salesman", encryptedPassword);
        });
        assertEquals("Username already exists", exception.getMessage());
    }

    @Test
    public void testGetAllSalesmen() {
        // Arrange
        when(userRepository.findAll()).thenReturn(List.of(user));

        // Act
        List<User> salesmen = userService.getAllSalesmen();

        // Assert
        assertNotNull(salesmen);
        assertEquals(1, salesmen.size());
        assertEquals(user.getUsername(), salesmen.get(0).getUsername());
        verify(userRepository, times(1)).findAll();
    }
}
