// src/main/java/dev/felipe/chefs_warehouse/services/ProveedorServicio.java

package dev.felipe.chefs_warehouse.services;

import dev.felipe.chefs_warehouse.models.Proveedor;
import dev.felipe.chefs_warehouse.repositories.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServicio {

    @Autowired
    private ProveedorRepositorio proveedorRepositorio;

    public List<Proveedor> obtenerTodosLosProveedores() {
        return proveedorRepositorio.findAll();
    }

    public Optional<Proveedor> obtenerProveedorPorId(Long id) {
        return proveedorRepositorio.findById(id);
    }

    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepositorio.save(proveedor);
    }

    public void eliminarProveedor(Long id) {
        proveedorRepositorio.deleteById(id);
    }
}
