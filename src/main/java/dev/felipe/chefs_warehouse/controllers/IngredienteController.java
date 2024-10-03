package dev.felipe.chefs_warehouse.controllers;

import dev.felipe.chefs_warehouse.models.Ingrediente;
import dev.felipe.chefs_warehouse.services.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    // Obtener todos los ingredientes
    @GetMapping
    public List<Ingrediente> obtenerTodosLosIngredientes() {
        return ingredienteService.obtenerTodosLosIngredientes();
    }

    // Obtener ingrediente por ID
    @GetMapping("/{id}")
    public Ingrediente obtenerIngredientePorId(@PathVariable Long id) {
        return ingredienteService.obtenerIngredientePorId(id);
    }

    // Crear un nuevo ingrediente
    @PostMapping
    public Ingrediente guardarIngrediente(@RequestBody Ingrediente ingrediente) {
        return ingredienteService.guardarIngrediente(ingrediente);
    }

    // Actualizar un ingrediente
    @PutMapping("/{id}")
    public Ingrediente actualizarIngrediente(@PathVariable Long id, @RequestBody Ingrediente ingrediente) {
        return ingredienteService.actualizarIngrediente(id, ingrediente);
    }

    // Eliminar un ingrediente
    @DeleteMapping("/{id}")
    public void eliminarIngrediente(@PathVariable Long id) {
        ingredienteService.eliminarIngrediente(id);
    }

    // Filtrar ingredientes por categoría
    @GetMapping("/categoria/{categoria}")
    public List<Ingrediente> obtenerIngredientesPorCategoria(@PathVariable String categoria) {
        return ingredienteService.obtenerIngredientesPorCategoria(categoria);
    }

    // Filtrar ingredientes por tipo de almacenamiento
    @GetMapping("/almacenamiento/{almacenamiento}")
    public List<Ingrediente> obtenerIngredientesPorAlmacenamiento(@PathVariable String almacenamiento) {
        return ingredienteService.obtenerIngredientesPorAlmacenamiento(almacenamiento);
    }

    // Filtrar ingredientes por fecha de caducidad
    @GetMapping("/fechaCaducidad/{fecha}")
    public List<Ingrediente> obtenerIngredientesPorFechaCaducidad(@PathVariable String fecha) {
        return ingredienteService.obtenerIngredientesPorFechaCaducidad(LocalDate.parse(fecha));
    }

    // Filtrar ingredientes por cantidad
    @GetMapping("/cantidad/{kilos}/{gramos}/{unidades}")
    public List<Ingrediente> obtenerIngredientesPorCantidad(@PathVariable int kilos, @PathVariable int gramos, @PathVariable int unidades) {
        return ingredienteService.obtenerIngredientesPorCantidad(kilos, gramos, unidades);
    }
}
