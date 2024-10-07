package dev.felipe.chefs_warehouse.controllers;

import dev.felipe.chefs_warehouse.models.Receta;
import dev.felipe.chefs_warehouse.services.RecetaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections; // Keep this import for Collections
// Removed import for Optional as it is not used

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RecetaController.class)
public class RecetaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private RecetaService recetaService;

    @BeforeEach
    public void setUp() {
        recetaService = Mockito.mock(RecetaService.class);
    }

    @Test
    public void testGetAllRecetas() throws Exception {
        Receta receta = new Receta();
        receta.setId(1L);
        receta.setNombre("Tortilla");
        when(recetaService.getAllRecetas()).thenReturn(Collections.singletonList(receta));

        mockMvc.perform(get("/api/v1/recetas"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nombre").value("Tortilla"));

        verify(recetaService, times(1)).getAllRecetas();
    }

    @Test
    public void testGetRecetaById() throws Exception {
        Receta receta = new Receta();
        receta.setId(1L);
        receta.setNombre("Tortilla");

        when(recetaService.getRecetaById(anyLong())).thenReturn(receta);

        mockMvc.perform(get("/api/v1/recetas/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Tortilla"));

        verify(recetaService, times(1)).getRecetaById(1L);
    }

    @Test
    public void testCreateReceta() throws Exception {
        Receta nuevaReceta = new Receta();
        nuevaReceta.setId(1L);
        nuevaReceta.setNombre("Tortilla");

        when(recetaService.createReceta(any(Receta.class))).thenReturn(nuevaReceta);

        mockMvc.perform(post("/api/v1/recetas")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Tortilla\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Tortilla"));

        verify(recetaService, times(1)).createReceta(any(Receta.class));
    }

    @Test
    public void testUpdateReceta() throws Exception {
        Receta updatedReceta = new Receta();
        updatedReceta.setId(1L);
        updatedReceta.setNombre("Tortilla Updated");

        when(recetaService.updateReceta(anyLong(), any(Receta.class))).thenReturn(updatedReceta);

        mockMvc.perform(put("/api/v1/recetas/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Tortilla Updated\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Tortilla Updated"));

        verify(recetaService, times(1)).updateReceta(anyLong(), any(Receta.class));
    }

    @Test
    public void testDeleteReceta() throws Exception {
        doNothing().when(recetaService).deleteReceta(anyLong());

        mockMvc.perform(delete("/api/v1/recetas/1"))
                .andExpect(status().isOk());

        verify(recetaService, times(1)).deleteReceta(1L);
    }
}
