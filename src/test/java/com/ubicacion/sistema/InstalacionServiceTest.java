package com.ubicacion.sistema;


import com.ubicacion.sistema.model.Instalacion;
import com.ubicacion.sistema.repository.InstalacionRepository;
import com.ubicacion.sistema.service.InstalacionService;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstalacionServiceTest {

    @Test
    void testCrearInstalacion() {
        InstalacionRepository repo = new InstalacionRepository();
        InstalacionService service = new InstalacionService(repo);

        Instalacion nueva = new Instalacion(
            null,
            "Tulio Triviño",
            "IMC 300",
            "Nueva",
            true,
            false,
            "Calle Test 123",
            "-12.0464,-77.0428",
            "activo"
        );

        Instalacion resultado = service.CrearInstalacion(nueva);

        assertNotNull(resultado.getId());
        assertEquals("Tulio Triviño", resultado.getCliente());
        assertEquals("IMC 300", resultado.getCopiadora());
        assertEquals("Nueva", resultado.getCondicion());
        assertTrue(resultado.isUsa220V());
        assertFalse(resultado.isTieneEstabilizador());
        assertEquals("Calle Test 123", resultado.getDireccion());
        assertEquals("-12.0464,-77.0428", resultado.getCoordenadas());
        assertEquals("activo", resultado.getEstado());

        List<Instalacion> todas = service.ObtenerInstalaciones();
        assertEquals(1, todas.size());
        assertSame(resultado, todas.get(0));
    }
}