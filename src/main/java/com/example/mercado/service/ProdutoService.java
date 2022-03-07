package com.example.mercado.service;

import com.example.mercado.model.Produto;
import com.example.mercado.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto findById(Long id){
        return produtoRepository.getById(id);
    }

    public Produto add(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto update(Long id, Produto produto){

        Produto result = produtoRepository.save(produto);
        return result;
    }

    public void delete(Long id){

        produtoRepository.deleteById(id);
    }
}
