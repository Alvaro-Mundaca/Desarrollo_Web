package com.ubicacion.sistema.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.ubicacion.sistema.model.Copiadora;

@Repository
public class CopiadoraRepository {

    public List<Copiadora> ListaCopiadoras = new ArrayList<>();
    public Long ContadorId = 1L; 
    
    
    public Copiadora Crear(@RequestBody Copiadora copiadora){
        copiadora.setId(ContadorId++);
        ListaCopiadoras.add(copiadora);
        return copiadora;
    }
    
    
    public List<Copiadora> Listar(){return ListaCopiadoras;}
    
    
    public ResponseEntity<Copiadora> BuscarPorId(Long id){
         return ListaCopiadoras.stream()
                 .filter(copiadora -> copiadora.getId()
                         .equals(id)).findFirst()
                 .map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
         
    }
    
    
    public ResponseEntity<?> Actualizar(long id, Copiadora copiadora) {
        for (int i = 0; i < ListaCopiadoras.size(); i++) {
            if (ListaCopiadoras.get(i).getId().equals(id)) {
                copiadora.setId(id);
                ListaCopiadoras.set(i, copiadora);
                return ResponseEntity.ok("Copiadora ACTUALIZADA CORRECTAMENTE con ID: " + id);
            }
            
        }
        
        return ResponseEntity.status(404).body("Copiadora NO ENCONTRADA con ID: " + id);
    }
    
    
    public ResponseEntity<?> ActualizarParcialmente(Long id, Copiadora parcial) {
        for (Copiadora copiadora: ListaCopiadoras){
            if (copiadora.getId().equals(id)) {
                if (parcial.getMarca() != null) copiadora.setMarca(parcial.getMarca());
                if (parcial.getModelo() != null) copiadora.setModelo(parcial.getModelo());
                if (parcial.getTipo() != null) copiadora.setTipo(parcial.getTipo());
                if (parcial.getEstado() != null) copiadora.setEstado(parcial.getEstado());
                return ResponseEntity.ok("Copiadora ACTUALIZADA PARCIALMENTE con ID: " + id);
            }
        }
        return ResponseEntity.status(404).body("Copiadora NO ENCONTRADA con ID: " + id);
    }
    
    
    public ResponseEntity<String> Eliminar(long id){
        boolean eliminado = ListaCopiadoras.removeIf(copiadora -> copiadora.getId().equals(id));
        
        if (eliminado) {       
            return ResponseEntity.ok("Copiadora ELIMINADA CORRECTAMENTE con ID: " + id);       
        } else {  
            return ResponseEntity.status(404).body("Copiadora NO ENCONTRADA con ID: " + id);        
        }
    }
    

}
