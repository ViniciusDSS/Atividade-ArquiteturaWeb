package com.att3.Atividade3.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DadosProdutoDTO {
    private Integer id;
    private String nome;
    private double preco;
    private CategoriaProdutoDTO categoria;
}