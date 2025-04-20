package com.ubicacion.sistema.service;

import com.ubicacion.sistema.model.Cliente;
import com.ubicacion.sistema.repository.ClienteRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }
    
    public Cliente CrearCliente(Cliente cliente){
        return repository.Crear(cliente);
    }
    
    
    public List<Cliente> ObtenerClientes(){
        return repository.Listar();
    }
    
    
    public ResponseEntity<Cliente> BuscarCliente(Long id){
        return repository.BuscarPorId(id);
    }
    
    
    public ResponseEntity<?> ActualizarCliente(Long id, Cliente cliente){
        return repository.Actualizar(id, cliente);
    } 
    
    public ResponseEntity<?> ActualizarClienteParcialmente(Long id, Cliente cliente){
        return repository.ActualizarParcialmente(id, cliente);
    }  
        
    
    public ResponseEntity<String> EliminarCliente(Long id){
        return repository.Eliminar(id);
    }  
    
      
}
