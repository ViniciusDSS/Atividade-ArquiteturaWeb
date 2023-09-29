package com.webarquitetura.att.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webarquitetura.att.models.Categoria;

@Repository
public interface CategoriaProdutoRepository extends JpaRepository<Categoria, Long>{


    List<Categoria> findByNome(String nome);

    @Query("SELECT c FROM Categoria c LEFT JOIN FETCH c.produtos WHERE c.id_categoria = :id_categoria")
    Optional<Categoria> findByIdWithProduto(@Param("id_categoria") Long id_categoria);


    List<Categoria> findByNomeStartingWith(@Param("nome") String nome);

    @Query("select cc from Categoria cc left join fetch cc.produto c where cc.id = :id ")
    Categoria findCategoriaFetchProduto(@Param("id") Long id);
}
