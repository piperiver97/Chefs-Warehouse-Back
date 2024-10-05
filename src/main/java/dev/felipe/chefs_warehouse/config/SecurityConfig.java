package dev.felipe.chefs_warehouse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.http.HttpMethod;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Value;

import dev.felipe.chefs_warehouse.facades.encryptations.Base64Encoder;
import dev.felipe.chefs_warehouse.services.JpaUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${api-endpoint}")
    String endpoint;

    MyBasicAuthenticationEntryPoint myBasicAuthenticationEntryPoint;

    JpaUserDetailsService jpaUserDetailsService;

    public SecurityConfig(JpaUserDetailsService jpaUserDetailsService,
                          MyBasicAuthenticationEntryPoint basicEntryPoint) {
        this.jpaUserDetailsService = jpaUserDetailsService;
        this.myBasicAuthenticationEntryPoint = basicEntryPoint;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .cors(cors -> cors.configurationSource(corsConfiguration()))
            .csrf(csrf -> csrf.disable())
            .formLogin(form -> form.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll() // Acceso a la consola H2
                .requestMatchers(HttpMethod.GET, "/api/ingredientes/**").permitAll() // Permitir acceso a ingredientes sin autenticación
                .requestMatchers(HttpMethod.GET, "/api/v1/ingredientes/**").permitAll() // Permitir acceso a ingredientes sin autenticación
                .requestMatchers(HttpMethod.GET, endpoint + "/login").hasAnyRole("ADMIN",  "USER") // Autenticación para login
                .requestMatchers(HttpMethod.POST, "/api/v1/ingredientes/**").authenticated() // Requiere autenticación para POST
                .requestMatchers(HttpMethod.PUT, "/api/v1/ingredientes/**").authenticated() // Requiere autenticación para PUT
                .requestMatchers(HttpMethod.DELETE, "/api/v1/ingredientes/**").authenticated() // Requiere autenticación para DELETE
                .requestMatchers(HttpMethod.GET, "/api/v1/proveedores/**").authenticated() // Requiere autenticación para DELETE
                .requestMatchers(HttpMethod.POST, "/api/v1/proveedores/**").authenticated() // Requiere autenticación para POST
                .requestMatchers(HttpMethod.PUT, "/api/v1/proveedores/**").authenticated() // Requiere autenticación para PUT
                .requestMatchers(HttpMethod.DELETE, "/api/v1/proveedores/**").authenticated() // Requiere autenticación para DELETE

                .anyRequest().authenticated()) 
            .userDetailsService(jpaUserDetailsService)
            .httpBasic(basic -> basic.authenticationEntryPoint(myBasicAuthenticationEntryPoint))
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

        http.headers(header -> header.frameOptions(frame -> frame.sameOrigin())); // Permitir H2 frame

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfiguration() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true); // Permitir el uso de credenciales
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173")); // Asegúrate de que sea la URL correcta de tu frontend
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Métodos permitidos
        configuration.setAllowedHeaders(Arrays.asList("*")); // Encabezados permitidos
    
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usa BCrypt para encriptar contraseñas
    }

    @Bean
    Base64Encoder base64Encoder() {
        return new Base64Encoder(); // Para el uso de codificación base64
    }
}
