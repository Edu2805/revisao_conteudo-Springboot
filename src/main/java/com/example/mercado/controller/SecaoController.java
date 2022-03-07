package com.example.mercado.controller;

import com.example.mercado.model.Secao;
import com.example.mercado.service.SecaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/secao")
public class SecaoController {

    private SecaoService secaoService;

    @GetMapping
    public ResponseEntity<List<Secao>> findAll() {
        List<Secao> list = secaoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Secao> findById(@PathVariable Long id) {
        Secao secao = secaoService.findById(id);
        return ResponseEntity.ok().body(secao);
    }

    @PostMapping
    public  ResponseEntity<Secao> insert(@RequestBody Secao secao){
        secao = secaoService.add(secao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}")
                .buildAndExpand(secao.getId()).toUri();

        return ResponseEntity.created(uri).body(secao);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Secao> update(@PathVariable Long id, @RequestBody Secao secao){

        Secao result = secaoService.update(id, secao);

        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        secaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
