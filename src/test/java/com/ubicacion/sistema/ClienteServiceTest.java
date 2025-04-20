package com.ubicacion.sistema;

import com.ubicacion.sistema.model.Cliente;
import com.ubicacion.sistema.repository.ClienteRepository;
import com.ubicacion.sistema.service.ClienteService;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {

    @Test
    void testCrearCliente() {
        
        ClienteRepository repo = new ClienteRepository();
        ClienteService service = new ClienteService(repo);

        
        Cliente nuevo = new Cliente(
            null, 
            "Diego", 
            "Maradona", 
            "87654321", 
            "987654321", 
            "notiene@gmail.com", 
            "INACTIVO", 
            "Una Empresa S.A.C.", 
            "20123456789"
            );

        
        Cliente resultado = service.CrearCliente(nuevo);

        assertNotNull(resultado.getId(), "El ID debe haberse asignado");
        assertEquals("Diego", resultado.getNombres());
        assertEquals("Maradona", resultado.getApellidos());
        assertEquals("87654321", resultado.getDni());
        assertEquals("987654321", resultado.getTelefono());
        assertEquals("INACTIVO", resultado.getEstado());
        assertEquals("Una Empresa S.A.C.", resultado.getRazonSocial());
        assertEquals("20123456789", resultado.getRuc());
        assertEquals("notiene@gmail.com", resultado.getEmail());

        List<Cliente> ListaClientes = service.ObtenerClientes();
        assertEquals(1, ListaClientes.size(), "Debe haber un solo cliente en el repo");
        assertSame(resultado, ListaClientes.get(0));
    }

    
}
