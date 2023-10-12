package com.att3.Atividade3.dtos;

import com.att3.Atividade3.models.AllArgsConstructor;
import com.att3.Atividade3.models.Builder;
import com.att3.Atividade3.models.Data;
import com.att3.Atividade3.models.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProdutoDTO {
    
    private Integer id;
    private String nome;
    private double preco;
    private Integer categoriaProdutoId;
}
