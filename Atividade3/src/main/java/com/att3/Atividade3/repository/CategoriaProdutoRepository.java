package com.att3.Atividade3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.att3.Atividade3.models.Categoria;

public interface CategoriaProdutoRepository extends JpaRepository<Categoria, Integer>{
    
        @Query("SELECT cc FROM categoria cc left join fetch cc.produto c where cc.id = :id")
        Categoria findCategoriaFetchProduto(@Param("id") Integer id);
}
