package com.example.mercado.service;

import com.example.mercado.model.Colaborador;
import com.example.mercado.repository.ColaboradorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ColaboradorService {

    private ColaboradorRepository colaboradorRepository;

    public List<Colaborador> findAll(){
        return colaboradorRepository.findAll();
    }

    public Colaborador findById(Long id){
        return colaboradorRepository.getById(id);
    }

    public Colaborador add(Colaborador colaborador){
        return colaboradorRepository.save(colaborador);
    }

    public Colaborador update(Long id, Colaborador colaborador){

        Colaborador result = colaboradorRepository.save(colaborador);
        return result;
    }

    public void delete(Long id){

        colaboradorRepository.deleteById(id);
    }
}
