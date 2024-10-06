package dev.felipe.chefs_warehouse.services;

import dev.felipe.chefs_warehouse.models.Ingrediente; // Asegúrate de importar Ingrediente
import dev.felipe.chefs_warehouse.models.Receta;
import dev.felipe.chefs_warehouse.repositories.RecetaRepository;
import dev.felipe.chefs_warehouse.repositories.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetaService {
    @Autowired
    private RecetaRepository recetaRepository;
    
    @Autowired
    private IngredienteRepository ingredienteRepository; // Cambié a minúscula

    public List<Receta> getAllRecetas() {
        return recetaRepository.findAll();
    }

    public Receta getRecetaById(Long id) {
        return recetaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Receta no encontrada con id: " + id));
    }

    public Receta createReceta(Receta receta) {
        return recetaRepository.save(receta);
    }

    public Receta updateReceta(Long id, Receta recetaDetails) {
        Receta receta = getRecetaById(id);
        receta.setNombre(recetaDetails.getNombre());
        receta.setTiempoPreparacion(recetaDetails.getTiempoPreparacion());
        receta.setTiempoCoccion(recetaDetails.getTiempoCoccion());
        receta.setPorciones(recetaDetails.getPorciones());
        receta.setDificultad(recetaDetails.getDificultad());
        receta.setElaboracion(recetaDetails.getElaboracion());
        receta.setTecnicasCocina(recetaDetails.getTecnicasCocina());
        receta.setImagen(recetaDetails.getImagen());
        receta.getIngredientes().clear();
        receta.getIngredientes().addAll(recetaDetails.getIngredientes());
        return recetaRepository.save(receta);
    }

    public void deleteReceta(Long id) {
        Receta receta = getRecetaById(id);
        recetaRepository.delete(receta);
    }

    // Método de ejemplo que utiliza IngredienteRepository
    public List<Ingrediente> findIngredientesByCategoria(String categoria) {
        return ingredienteRepository.findByCategoria(categoria);
    }
}
