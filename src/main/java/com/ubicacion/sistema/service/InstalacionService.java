package com.ubicacion.sistema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ubicacion.sistema.model.Instalacion;
import com.ubicacion.sistema.repository.InstalacionRepository;

@Service
public class InstalacionService {

    private final InstalacionRepository repository;

    public InstalacionService(InstalacionRepository repository) {
        this.repository = repository;
    }
    
    public Instalacion CrearInstalacion(Instalacion instalacion){
        return repository.Crear(instalacion);
    }
    
    
    public List<Instalacion> ObtenerInstalaciones(){
        return repository.Listar();
    }
    
    
    public ResponseEntity<Instalacion> BuscarInstalacion(Long id){
        return repository.BuscarPorId(id);
    }
    
    
    public ResponseEntity<?> ActualizarInstalacion(Long id, Instalacion instalacion){
        return repository.Actualizar(id, instalacion);
    } 
    
    public ResponseEntity<?> ActualizarInstalacionParcialmente(Long id, Instalacion instalacion){
        return repository.ActualizarParcialmente(id, instalacion);
    }  
        
    
    public ResponseEntity<String> EliminarInstalacion(Long id){
        return repository.Eliminar(id);
    }  


}
