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

import com.ubicacion.sistema.model.Copiadora;
import com.ubicacion.sistema.service.CopiadoraService;

@RestController
@RequestMapping("/copiadora")
public class CopiadoraController {

    private final CopiadoraService service;

    public CopiadoraController(CopiadoraService service) {
        this.service = service;
    }
    
    
    @GetMapping
    public List<Copiadora> ObtenerCopiadoras(){
        return service.ObtenerCopiadoras();
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Copiadora> BuscarCopiadoras(@PathVariable Long id){
        return service.BuscarCopiadora(id);
    }
    
    
    @PostMapping("/crear")
    public ResponseEntity<Copiadora> CrearCopiadora(@RequestBody Copiadora copiadora) {
        Copiadora nuevo = service.CrearCopiadora(copiadora);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<?> ActualizarCopiadora(@PathVariable Long id, @RequestBody Copiadora copiadora) {
        return service.ActualizarCopiadora(id, copiadora);
    }
    
    
    @PatchMapping("/{id}")
    public ResponseEntity<?> ActualizarParcialmente(@PathVariable Long id, @RequestBody Copiadora copiadora) {
        return service.ActualizarCopiadoraParcialmente(id, copiadora);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> EliminarCopiadora(@PathVariable Long id){
        return service.EliminarCopiadora(id);
    }

}
