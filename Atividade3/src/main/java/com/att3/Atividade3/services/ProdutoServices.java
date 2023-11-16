package com.att3.Atividade3.services;

import java.util.List;

import com.att3.Atividade3.dtos.DadosProdutoDTO;
import com.att3.Atividade3.dtos.ProdutoDTO;
import com.att3.Atividade3.models.Produto;

public interface ProdutoServices {
        Produto salvar(ProdutoDTO produtoDTO);
        List<ProdutoDTO> listAll();
        DadosProdutoDTO obtainById(Integer id);
        void delete(Integer id);
        void update(Integer id, ProdutoDTO dto);
    }
    
