package dev.felipe.chefs_warehouse.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;

@Embeddable
@Data
public class RecetaIngredienteId implements Serializable {
    @Column(name = "receta_id")
    private Long recetaId;

    @Column(name = "ingrediente_id")
    private Long ingredienteId;
}