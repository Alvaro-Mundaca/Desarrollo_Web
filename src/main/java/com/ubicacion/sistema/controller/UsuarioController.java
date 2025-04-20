package com.ubicacion.sistema.controller;

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

import com.ubicacion.sistema.model.Usuario;
import com.ubicacion.sistema.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    
    
    @GetMapping
    public List<Usuario> ObtenerUsuarios(){
        return service.ObtenerUsuarios();
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> BuscarUsuarios(@PathVariable Long id){
        return service.BuscarUsuario(id);
    }
    
    
    @PostMapping("/crear")
    public ResponseEntity<Usuario> CrearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevo = service.CrearUsuario(usuario);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<?> ActualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return service.ActualizarUsuario(id, usuario);
    }
    
    
    @PatchMapping("/{id}")
    public ResponseEntity<?> ActualizarParcialmente(@PathVariable Long id, @RequestBody Usuario usuario) {
        return service.ActualizarUsuarioParcialmente(id, usuario);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> EliminarUsuario(@PathVariable Long id){
        return service.EliminarUsuario(id);
    }

}
