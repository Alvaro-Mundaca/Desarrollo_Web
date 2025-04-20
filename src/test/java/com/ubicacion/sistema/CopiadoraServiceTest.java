package com.ubicacion.sistema;

import com.ubicacion.sistema.model.Copiadora;
import com.ubicacion.sistema.repository.CopiadoraRepository;
import com.ubicacion.sistema.service.CopiadoraService;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CopiadoraServiceTest {

    @Test
    void testCrearCopiadora() {

        CopiadoraRepository repo = new CopiadoraRepository();
        CopiadoraService service = new CopiadoraService(repo);

        Copiadora nueva = new Copiadora(
            null,               
            "IMC 300",       
            "Color",         
            "operativa"        
        );

        Copiadora resultado = service.CrearCopiadora(nueva);

        assertNotNull(resultado.getId(), "El ID debe haberse asignado");
        assertEquals("IMC 300", resultado.getModelo());
        assertEquals("Color", resultado.getTipo());
        assertEquals("operativa", resultado.getEstado());

        List<Copiadora> todas = service.ObtenerCopiadoras();
        assertEquals(1, todas.size(), "Debe haber una sola copiadora en el repo");
        assertSame(resultado, todas.get(0));
    }
}