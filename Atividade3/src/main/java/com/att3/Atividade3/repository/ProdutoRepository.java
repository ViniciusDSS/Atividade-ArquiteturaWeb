package com.att3.Atividade3.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.att3.Atividade3.models.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Integer>{



    List<Produto> findBynomeLike(String nome);
    List<Produto> findByPrecoGreaterThan(Double preco);
    List<Produto> findByPrecoLessThanEqual(Double preco);
    List<Produto> findByPrecoProdutos(double d);
}
