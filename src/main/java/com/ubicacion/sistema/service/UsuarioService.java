package com.ubicacion.sistema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ubicacion.sistema.model.Usuario;
import com.ubicacion.sistema.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }
    
    public Usuario CrearUsuario(Usuario usuario){
        return repository.Crear(usuario);
    }
    
    
    public List<Usuario> ObtenerUsuarios(){
        return repository.Listar();
    }
    
    
    public ResponseEntity<Usuario> BuscarUsuario(Long id){
        return repository.BuscarPorId(id);
    }
    
    
    public ResponseEntity<?> ActualizarUsuario(Long id, Usuario usuario){
        return repository.Actualizar(id, usuario);
    } 
    
    public ResponseEntity<?> ActualizarUsuarioParcialmente(Long id, Usuario usuario){
        return repository.ActualizarParcialmente(id, usuario);
    }  
        
    
    public ResponseEntity<String> EliminarUsuario(Long id){
        return repository.Eliminar(id);
    }  

}
