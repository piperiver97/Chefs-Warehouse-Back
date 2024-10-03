// src/main/java/dev/felipe/chefs_warehouse/controllers/ProveedorControlador.java

package dev.felipe.chefs_warehouse.controllers;

import dev.felipe.chefs_warehouse.models.Proveedor;
import dev.felipe.chefs_warehouse.services.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proveedores")
public class ProveedorControlador {

    @Autowired
    private ProveedorServicio proveedorServicio;

    @GetMapping
    public List<Proveedor> obtenerTodosLosProveedores() {
        return proveedorServicio.obtenerTodosLosProveedores();
    }

    @PostMapping
    public Proveedor crearProveedor(@RequestBody Proveedor proveedor) {
        return proveedorServicio.guardarProveedor(proveedor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id) {
        proveedorServicio.eliminarProveedor(id);
        return ResponseEntity.noContent().build();
    }
}
