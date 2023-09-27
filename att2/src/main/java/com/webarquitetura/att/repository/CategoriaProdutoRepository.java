package com.webarquitetura.att.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webarquitetura.att.models.Categoria;

@Repository
public interface CategoriaProdutoRepository extends JpaRepository<Categoria, Long>{


    List<Categoria> findByNome(String nome);
}
