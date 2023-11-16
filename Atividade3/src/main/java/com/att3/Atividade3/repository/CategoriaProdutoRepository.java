package com.att3.Atividade3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import com.att3.Atividade3.models.CategoriaProduto;

public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Integer>{
    
        @Query("SELECT cc FROM categoria cc left join fetch cc.produto c where cc.id = :id")
        CategoriaProduto findCategoriaFetchProduto(@Param("id") Integer id);

        List<CategoriaProduto> findByNameStartingWith(String name);
}
