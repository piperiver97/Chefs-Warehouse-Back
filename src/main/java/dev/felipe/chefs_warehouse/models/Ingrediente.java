package dev.felipe.chefs_warehouse.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ingredientes")  // Especifica el nombre exacto de la tabla
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    
    @Column(name = "cantidad_kilos")
    private Integer cantidadKilos;
    
    @Column(name = "cantidad_gramos")
    private Integer cantidadGramos;
    
    @Column(name = "cantidad_unidades")
    private Integer cantidadUnidades;
    
    @Column(name = "fecha_de_caducidad")
    private LocalDate fechaDeCaducidad;
    
    private String almacenamiento;
    private String categoria;
    private String imagen;
    
    @Column(name = "proveedor_id")
    private Long proveedorId;

    // Getters y setters
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

    public Integer getCantidadKilos() {
        return cantidadKilos;
    }

    public void setCantidadKilos(Integer cantidadKilos) {
        this.cantidadKilos = cantidadKilos;
    }

    public Integer getCantidadGramos() {
        return cantidadGramos;
    }

    public void setCantidadGramos(Integer cantidadGramos) {
        this.cantidadGramos = cantidadGramos;
    }

    public Integer getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(Integer cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public LocalDate getFechaDeCaducidad() {
        return fechaDeCaducidad;
    }

    public void setFechaDeCaducidad(LocalDate fechaDeCaducidad) {
        this.fechaDeCaducidad = fechaDeCaducidad;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }
}