package com.ubicacion.sistema.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.ubicacion.sistema.model.Instalacion;

@Repository
public class InstalacionRepository {

    public List<Instalacion> ListaInstalacions = new ArrayList<>();
    public Long ContadorId = 1L; 
    
    
    public Instalacion Crear(@RequestBody Instalacion instalacion){
        instalacion.setId(ContadorId++);
        ListaInstalacions.add(instalacion);
        return instalacion;
    }
    
    
    public List<Instalacion> Listar(){return ListaInstalacions;}
    
    
    public ResponseEntity<Instalacion> BuscarPorId(Long id){
         return ListaInstalacions.stream()
                 .filter(instalacion -> instalacion.getId()
                         .equals(id)).findFirst()
                 .map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
         
    }
    
    
    public ResponseEntity<?> Actualizar(long id, Instalacion instalacion) {
        for (int i = 0; i < ListaInstalacions.size(); i++) {
            if (ListaInstalacions.get(i).getId().equals(id)) {
                instalacion.setId(id);
                ListaInstalacions.set(i, instalacion);
                return ResponseEntity.ok("Instalacion ACTUALIZADA CORRECTAMENTE con ID: " + id);
            }
            
        }
        
        return ResponseEntity.status(404).body("Instalacion NO ENCONTRADA con ID: " + id);
    }
    
    
    public ResponseEntity<?> ActualizarParcialmente(Long id, Instalacion parcial) {
        for (Instalacion instalacion: ListaInstalacions){
            if (instalacion.getId().equals(id)) {
                if (parcial.getCliente() != null) instalacion.setCliente(parcial.getCliente());
                if (parcial.getCopiadora() != null) instalacion.setCopiadora(parcial.getCopiadora());
                if (parcial.getCondicion() != null) instalacion.setCondicion(parcial.getCondicion());
                instalacion.setUsa220V(parcial.isUsa220V());
                instalacion.setTieneEstabilizador(parcial.isTieneEstabilizador());
                if (parcial.getDireccion() != null) instalacion.setDireccion(parcial.getDireccion());
                if (parcial.getCoordenadas() != null) instalacion.setCoordenadas(parcial.getCoordenadas());
                if (parcial.getEstado() != null) instalacion.setEstado(parcial.getEstado());
                return ResponseEntity.ok("Instalacion ACTUALIZADA PARCIALMENTE con ID: " + id);
            }
        }
        return ResponseEntity.status(404).body("Instalacion NO ENCONTRADA con ID: " + id);
    }
    
    
    public ResponseEntity<String> Eliminar(long id){
        boolean eliminado = ListaInstalacions.removeIf(instalacion -> instalacion.getId().equals(id));
        
        if (eliminado) {       
            return ResponseEntity.ok("Instalacion ELIMINADA CORRECTAMENTE con ID: " + id);       
        } else {  
            return ResponseEntity.status(404).body("Instalacion NO ENCONTRADA con ID: " + id);        
        }
    }

}
