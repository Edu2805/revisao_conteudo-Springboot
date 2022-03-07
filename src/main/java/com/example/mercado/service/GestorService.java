package com.example.mercado.service;

import com.example.mercado.model.Gestor;
import com.example.mercado.repository.GestorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GestorService {

    private GestorRepository gestorRepository;

    public List<Gestor> findAll(){
        return gestorRepository.findAll();
    }

    public Gestor findById(Long id){
        return gestorRepository.getById(id);
    }

    public Gestor add(Gestor gestor){
        return gestorRepository.save(gestor);
    }

    public Gestor update(Long id, Gestor gestor){

        Gestor result = gestorRepository.save(gestor);
        return result;
    }

    public void delete(Long id){

        gestorRepository.deleteById(id);
    }
}
