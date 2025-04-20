package com.ubicacion.sistema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ubicacion.sistema.model.Copiadora;
import com.ubicacion.sistema.repository.CopiadoraRepository;

@Service
public class CopiadoraService {

private final CopiadoraRepository repository;

    public CopiadoraService(CopiadoraRepository repository) {
        this.repository = repository;
    }
    
    public Copiadora CrearCopiadora(Copiadora copiadora){
        return repository.Crear(copiadora);
    }
    
    
    public List<Copiadora> ObtenerCopiadoras(){
        return repository.Listar();
    }
    
    
    public ResponseEntity<Copiadora> BuscarCopiadora(Long id){
        return repository.BuscarPorId(id);
    }
    
    
    public ResponseEntity<?> ActualizarCopiadora(Long id, Copiadora copiadora){
        return repository.Actualizar(id, copiadora);
    } 
    
    public ResponseEntity<?> ActualizarCopiadoraParcialmente(Long id, Copiadora copiadora){
        return repository.ActualizarParcialmente(id, copiadora);
    }  
        
    
    public ResponseEntity<String> EliminarCopiadora(Long id){
        return repository.Eliminar(id);
    }  

}
