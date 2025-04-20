package com.ubicacion.sistema;
import com.ubicacion.sistema.model.Usuario;
import com.ubicacion.sistema.repository.UsuarioRepository;
import com.ubicacion.sistema.service.UsuarioService;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioServiceTest {

    @Test
    void testCrearUsuario() {
        UsuarioRepository repo = new UsuarioRepository();
        UsuarioService service = new UsuarioService(repo);

        Usuario nuevo = new Usuario(
            null,
            "Tulio",
            "Triviño",
            "87654321",
            "987654321",
            "Tulio2025@gmail.com",
            "activo",
            "admin",
            "******",
            "Calle Test 123"
            );

        Usuario resultado = service.CrearUsuario(nuevo);

        assertNotNull(resultado.getId());
        assertEquals("admin", resultado.getTipo());
        assertEquals("******", resultado.getClave());
        assertEquals("Calle Test 123", resultado.getDireccion());
        assertEquals("Tulio", resultado.getNombres());
        assertEquals("Triviño", resultado.getApellidos());
        assertEquals("87654321", resultado.getDni());
        assertEquals("987654321", resultado.getTelefono());
        assertEquals("activo", resultado.getEstado());

        List<Usuario> todos = service.ObtenerUsuarios();
        assertEquals(1, todos.size());
        assertSame(resultado, todos.get(0));
    }
}