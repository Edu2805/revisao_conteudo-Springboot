package com.example.mercado.model.dto;

import com.example.mercado.model.Colaborador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ColaboradorDto {

    private String telefone;

    public Colaborador converter(Colaborador colaborador){
        colaborador.setTelefone(telefone);
        return colaborador;
    }
}
