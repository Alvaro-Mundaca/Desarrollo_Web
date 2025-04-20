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

import com.ubicacion.sistema.model.Instalacion;
import com.ubicacion.sistema.service.InstalacionService;

@RestController
@RequestMapping("/instalacion")
public class InstalacionController {

private final InstalacionService service;

    public InstalacionController(InstalacionService service) {
        this.service = service;
    }
    
    
    @GetMapping
    public List<Instalacion> ObtenerInstalacions(){
        return service.ObtenerInstalaciones();
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Instalacion> BuscarInstalacions(@PathVariable Long id){
        return service.BuscarInstalacion(id);
    }
    
    
    @PostMapping("/crear")
    public ResponseEntity<Instalacion> CrearInstalacion(@RequestBody Instalacion instalacion) {
        Instalacion nuevo = service.CrearInstalacion(instalacion);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<?> ActualizarInstalacion(@PathVariable Long id, @RequestBody Instalacion instalacion) {
        return service.ActualizarInstalacion(id, instalacion);
    }
    
    
    @PatchMapping("/{id}")
    public ResponseEntity<?> ActualizarParcialmente(@PathVariable Long id, @RequestBody Instalacion instalacion) {
        return service.ActualizarInstalacionParcialmente(id, instalacion);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> EliminarInstalacion(@PathVariable Long id){
        return service.EliminarInstalacion(id);
    }

}
