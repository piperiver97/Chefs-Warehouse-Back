package dev.felipe.chefs_warehouse.models;

import jakarta.persistence.*; // Cambiado de javax.persistence a jakarta.persistence
import java.time.LocalDate;

@Entity
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double cantidadDisponible;
    private String unidadMedida;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaVencimiento;

    private Double costoPorUnidad;

    public Ingrediente() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Double cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Double getCostoPorUnidad() {
        return costoPorUnidad;
    }

    public void setCostoPorUnidad(Double costoPorUnidad) {
        this.costoPorUnidad = costoPorUnidad;
    }
}
