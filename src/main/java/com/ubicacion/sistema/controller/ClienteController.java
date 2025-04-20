package com.ubicacion.sistema.controller;

import com.ubicacion.sistema.model.Cliente;
import com.ubicacion.sistema.service.ClienteService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }
    
    
    @GetMapping
    public List<Cliente> ObtenerClientes(){
        return service.ObtenerClientes();
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> BuscarClientes(@PathVariable Long id){
        return service.BuscarCliente(id);
    }
    
    
    @PostMapping("/crear")
    public ResponseEntity<Cliente> CrearCliente(@RequestBody Cliente cliente) {
        Cliente nuevo = service.CrearCliente(cliente);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<?> ActualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return service.ActualizarCliente(id, cliente);
    }
    
    
    @PatchMapping("/{id}")
    public ResponseEntity<?> ActualizarParcialmente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return service.ActualizarClienteParcialmente(id, cliente);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> EliminarCliente(@PathVariable Long id){
        return service.EliminarCliente(id);
    }
    
    
}
