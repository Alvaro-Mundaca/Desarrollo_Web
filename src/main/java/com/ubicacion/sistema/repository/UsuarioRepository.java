package com.ubicacion.sistema.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.ubicacion.sistema.model.Usuario;


@Repository
public class UsuarioRepository {

    public List<Usuario> ListaUsuarios = new ArrayList<>();
    public Long ContadorId = 1L; 
    
    
    public Usuario Crear(@RequestBody Usuario usuario){
        usuario.setId(ContadorId++);
        ListaUsuarios.add(usuario);
        return usuario;
    }
    
    
    public List<Usuario> Listar(){return ListaUsuarios;}
    
    
    public ResponseEntity<Usuario> BuscarPorId(Long id){
         return ListaUsuarios.stream()
                 .filter(usuario -> usuario.getId()
                         .equals(id)).findFirst()
                 .map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
         
    }
    
    
    public ResponseEntity<?> Actualizar(long id, Usuario usuario) {
        for (int i = 0; i < ListaUsuarios.size(); i++) {
            if (ListaUsuarios.get(i).getId().equals(id)) {
                usuario.setId(id);
                ListaUsuarios.set(i, usuario);
                return ResponseEntity.ok("Usuario ACTUALIZADO CORRECTAMENTE con ID: " + id);
            }
            
        }
        
        return ResponseEntity.status(404).body("Usuario NO ENCONTRADO con ID: " + id);
    }
    
    
    public ResponseEntity<?> ActualizarParcialmente(Long id, Usuario parcial) {
        for (Usuario usuario: ListaUsuarios){
            if (usuario.getId().equals(id)) {
                if (parcial.getNombres() != null) usuario.setNombres(parcial.getNombres());
                if (parcial.getApellidos() != null) usuario.setApellidos(parcial.getApellidos());
                if (parcial.getDni() != null) usuario.setDni(parcial.getDni());
                if (parcial.getTelefono() != null) usuario.setTelefono(parcial.getTelefono());
                if (parcial.getTipo() != null) usuario.setTipo(parcial.getTipo());
                if (parcial.getDireccion() != null) usuario.setDireccion(parcial.getDireccion());
                if (parcial.getClave() != null) usuario.setClave(parcial.getClave());
                if (parcial.getEstado() != null) usuario.setEstado(parcial.getEstado());
                if (parcial.getEmail() != null) usuario.setEmail(parcial.getEmail());
                return ResponseEntity.ok("Usuario ACTUALIZADO PARCIALMENTE con ID: " + id);
            }
        }
        return ResponseEntity.status(404).body("Usuario NO ENCONTRADO con ID: " + id);
    }
    
    
    public ResponseEntity<String> Eliminar(long id){
        boolean eliminado = ListaUsuarios.removeIf(usuario -> usuario.getId().equals(id));
        
        if (eliminado) {       
            return ResponseEntity.ok("Usuario ELIMINADO CORRECTAMENTE con ID: " + id);       
        } else {  
            return ResponseEntity.status(404).body("Usuario NO ENCONTRADO con ID: " + id);        
        }
    }

}
