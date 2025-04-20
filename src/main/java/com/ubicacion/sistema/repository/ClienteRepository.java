package com.ubicacion.sistema.repository;

import com.ubicacion.sistema.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class ClienteRepository {
    
    public List<Cliente> ListaClientes = new ArrayList<>();
    public Long ContadorId = 1L; 
    
    
    public Cliente Crear(@RequestBody Cliente cliente){
        cliente.setId(ContadorId++);
        ListaClientes.add(cliente);
        return cliente;
    }
    
    
    public List<Cliente> Listar(){return ListaClientes;}
    
    
    public ResponseEntity<Cliente> BuscarPorId(Long id){
         return ListaClientes.stream()
                 .filter(cliente -> cliente.getId()
                         .equals(id)).findFirst()
                 .map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
         
    }
    
    
    public ResponseEntity<?> Actualizar(long id, Cliente cliente) {
        for (int i = 0; i < ListaClientes.size(); i++) {
            if (ListaClientes.get(i).getId().equals(id)) {
                cliente.setId(id);
                ListaClientes.set(i, cliente);
                return ResponseEntity.ok("Cliente ACTUALIZADO CORRECTAMENTE con ID: " + id);
            }
            
        }
        
        return ResponseEntity.status(404).body("Cliente NO ENCONTRADO con ID: " + id);
    }
    
    
    public ResponseEntity<?> ActualizarParcialmente(Long id, Cliente parcial) {
        for (Cliente cliente: ListaClientes){
            if (cliente.getId().equals(id)) {
                if (parcial.getNombres() != null) cliente.setNombres(parcial.getNombres());
                if (parcial.getApellidos() != null) cliente.setApellidos(parcial.getApellidos());
                if (parcial.getDni() != null) cliente.setDni(parcial.getDni());
                if (parcial.getTelefono() != null) cliente.setTelefono(parcial.getTelefono());
                if (parcial.getRazonSocial() != null) cliente.setRazonSocial(parcial.getRazonSocial());
                if (parcial.getRuc() != null) cliente.setRuc(parcial.getRuc());
                if (parcial.getEstado() != null) cliente.setEstado(parcial.getEstado());
                return ResponseEntity.ok("Cliente ACTUALIZADO PARCIALMENTE con ID: " + id);
            }
        }
        return ResponseEntity.status(404).body("Cliente NO ENCONTRADO con ID: " + id);
    }
    
    
    public ResponseEntity<String> Eliminar(long id){
        boolean eliminado = ListaClientes.removeIf(cliente -> cliente.getId().equals(id));
        
        if (eliminado) {       
            return ResponseEntity.ok("Cliente ELIMINADO CORRECTAMENTE con ID: " + id);       
        } else {  
            return ResponseEntity.status(404).body("Cliente NO ENCONTRADO con ID: " + id);        
        }
    }
    
    
}
