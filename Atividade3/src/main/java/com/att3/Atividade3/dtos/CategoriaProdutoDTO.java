package com.att3.Atividade3.dtos;

import com.att3.Atividade3.models.AllArgsConstructor;
import com.att3.Atividade3.models.Builder;
import com.att3.Atividade3.models.Data;
import com.att3.Atividade3.models.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaProdutoDTO {

    private Integer id;
    private String nome;
}
