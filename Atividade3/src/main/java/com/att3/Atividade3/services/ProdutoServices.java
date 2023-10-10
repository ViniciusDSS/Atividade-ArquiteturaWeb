package com.att3.Atividade3.services;

import java.util.List;

import com.att3.Atividade3.models.Produto;

public interface ProdutoServices {

    Produto salvar(ProdutoDTO produtoDTO);

    List<ProdutoDTO> listarTodos();

    DadosProdutoDTO obterPorId(Integer id);

    void excluir(Integer id);

    void editar(Integer id, ProdutoDTO dto);
    
} 