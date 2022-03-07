package com.example.mercado.controller;

import com.example.mercado.model.Gestor;
import com.example.mercado.service.GestorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/gestor")
public class GestorController {

    private GestorService gestorService;

    @GetMapping
    public ResponseEntity<List<Gestor>> findAll() {
        List<Gestor> list = gestorService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Gestor> findById(@PathVariable Long id) {
        Gestor gestor = gestorService.findById(id);
        return ResponseEntity.ok().body(gestor);
    }

    @PostMapping
    public  ResponseEntity<Gestor> insert(@RequestBody Gestor gestor){
        gestor = gestorService.add(gestor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}")
                .buildAndExpand(gestor.getId()).toUri();

        return ResponseEntity.created(uri).body(gestor);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Gestor> update(@PathVariable Long id, @RequestBody Gestor gestor){

        Gestor result = gestorService.update(id, gestor);

        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        gestorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
