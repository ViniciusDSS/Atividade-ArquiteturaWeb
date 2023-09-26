package com.webarquitetura.att.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webarquitetura.att.models.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    List<Produto> findByPrecoGreaterThan(Double valor);

}
 