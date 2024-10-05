// src/main/java/dev/felipe/chefs_warehouse/controllers/ProveedorControlador.java

package dev.felipe.chefs_warehouse.controllers;

import dev.felipe.chefs_warehouse.models.Proveedor;
import dev.felipe.chefs_warehouse.services.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/categorias")
    public List<String> obtenerCategorias() {
        return proveedorServicio.obtenerCategorias();
    }

    // Nuevo método PUT para actualizar un proveedor existente
    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Long id, @RequestBody Proveedor proveedorActualizado) {
        Optional<Proveedor> proveedorExistenteOptional = proveedorServicio.obtenerProveedorPorId(id);

        if (proveedorExistenteOptional.isEmpty()) {
            // Si el proveedor no existe, devolver un error 404
            return ResponseEntity.notFound().build();
        }

        Proveedor proveedorExistente = proveedorExistenteOptional.get();
        // Actualizar los campos del proveedor existente con los nuevos datos
        proveedorExistente.setNombre(proveedorActualizado.getNombre());
        proveedorExistente.setTelefono(proveedorActualizado.getTelefono());
        proveedorExistente.setCategoria(proveedorActualizado.getCategoria());

        // Guardar el proveedor actualizado en la base de datos
        Proveedor proveedorGuardado = proveedorServicio.guardarProveedor(proveedorExistente);

        // Devolver el proveedor actualizado con un código 200 OK
        return ResponseEntity.ok(proveedorGuardado);
    }
}
