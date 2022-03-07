package com.example.mercado.controller;

import com.example.mercado.model.Colaborador;
import com.example.mercado.model.dto.ColaboradorDto;
import com.example.mercado.service.ColaboradorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/colaborador")
public class ColaboradorController {

    private ColaboradorService colaboradorService;

    @GetMapping
    public ResponseEntity<List<Colaborador>> findAll() {
        List<Colaborador> list = colaboradorService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Colaborador> findById(@PathVariable Long id) {
        Colaborador colaborador = colaboradorService.findById(id);
        return ResponseEntity.ok().body(colaborador);
    }

    @PostMapping
    public  ResponseEntity<Colaborador> insert(@RequestBody Colaborador colaborador){
        colaborador = colaboradorService.add(colaborador);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}")
                .buildAndExpand(colaborador.getId()).toUri();

        return ResponseEntity.created(uri).body(colaborador);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Colaborador> update(@PathVariable Long id, @RequestBody ColaboradorDto colaborador){
        //colaborador = colaboradorService.update(id, colaborador);
        //ColaboradorDto colaboradorDto
        Colaborador result = colaboradorService.update(id, colaborador.converter(colaboradorService.findById(id)));

        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        colaboradorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
