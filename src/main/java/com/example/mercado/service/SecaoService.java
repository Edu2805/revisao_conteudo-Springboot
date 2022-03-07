package com.example.mercado.service;

import com.example.mercado.model.Colaborador;
import com.example.mercado.model.Secao;
import com.example.mercado.repository.ColaboradorRepository;
import com.example.mercado.repository.SecaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SecaoService {

    private SecaoRepository secaoRepository;

    public List<Secao> findAll(){
        return secaoRepository.findAll();
    }

    public Secao findById(Long id){
        return secaoRepository.getById(id);
    }

    public Secao add(Secao secao){
        return secaoRepository.save(secao);
    }

    public Secao update(Long id, Secao secao){

        Secao result = secaoRepository.save(secao);
        return result;
    }

    public void delete(Long id){

        secaoRepository.deleteById(id);
    }
}
