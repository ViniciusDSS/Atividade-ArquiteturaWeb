package com.webarquitetura.att.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webarquitetura.att.models.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    @Query("SELECT p FROM Produto p WHERE p.preco > :valor")
    List<Produto> findByPrecoGreaterThan(@Param("valor") Double valor);

    @Query("SELECT p FROM Produto p WHERE p.preco <= :valor")
    List<Produto> findByPrecoLessThan(@Param("valor") Double valor);

    List<Produto> findByNome(String nome);

}
 