package dev.felipe.chefs_warehouse.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "recetas_ingredientes")
public class RecetaIngrediente {
    @EmbeddedId
    private RecetaIngredienteId id = new RecetaIngredienteId();

    @ManyToOne
    @MapsId("recetaId")
    @JoinColumn(name = "receta_id")
    private Receta receta;

    @ManyToOne
    @MapsId("ingredienteId")
    @JoinColumn(name = "ingrediente_id")
    private Ingrediente ingrediente;

    private Float cantidad;

    @Column(name = "unidad_medida")
    private String unidadMedida;
}