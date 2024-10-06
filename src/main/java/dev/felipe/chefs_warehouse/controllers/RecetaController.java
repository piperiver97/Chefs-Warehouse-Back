package dev.felipe.chefs_warehouse.controllers;

import dev.felipe.chefs_warehouse.models.Receta;
import dev.felipe.chefs_warehouse.services.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recetas")
@CrossOrigin(origins = "http://localhost:5173")
public class RecetaController {
    @Autowired
    private RecetaService recetaService;

    @GetMapping
    public List<Receta> getAllRecetas() {
        return recetaService.getAllRecetas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receta> getRecetaById(@PathVariable Long id) {
        Receta receta = recetaService.getRecetaById(id);
        return ResponseEntity.ok(receta);
    }

    @PostMapping
    public ResponseEntity<Receta> createReceta(@RequestBody Receta receta) {
        Receta nuevaReceta = recetaService.createReceta(receta);
        return ResponseEntity.ok(nuevaReceta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receta> updateReceta(@PathVariable Long id, @RequestBody Receta recetaDetails) {
        Receta updatedReceta = recetaService.updateReceta(id, recetaDetails);
        return ResponseEntity.ok(updatedReceta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReceta(@PathVariable Long id) {
        recetaService.deleteReceta(id);
        return ResponseEntity.ok().build();
    }
}