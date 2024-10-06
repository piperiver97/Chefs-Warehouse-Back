package dev.felipe.chefs_warehouse.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "recetas")
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "tiempo_preparacion", nullable = false)
    private Integer tiempoPreparacion;

    @Column(name = "tiempo_coccion", nullable = false)
    private Integer tiempoCoccion;

    private Integer porciones;

    private String dificultad;

    @Column(columnDefinition = "TEXT")
    private String elaboracion;

    @Column(name = "tecnicas_cocina", columnDefinition = "TEXT")
    private String tecnicasCocina;

    private String imagen;

    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RecetaIngrediente> ingredientes = new HashSet<>();
}