package com.webarquitetura.att.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webarquitetura.att.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produto inserir (Produto produto) {
        entityManager.merge(produto);
        return produto;
    }

    @Transactional
    public Produto editar (Produto produto) {
        entityManager.merge(produto);
        return produto;
    }
    
    @Transactional
    public void delete (Produto produto) {
        entityManager.remove(produto);
    }

    @Transactional
    public List<Produto> consultarProdutos (){
        return entityManager.createQuery("from Produto", Produto.class).getResultList();
    }

    @Transactional
    public List<Produto> consultarPorId(String id_produto){
        String sql = "SELECT c FROM tbl_produtos c WHERE c.id_produto like :id_produto";
        TypedQuery<Produto> query = entityManager.createQuery(sql, Produto.class);
        query.setParameter("id_produto","%"+id_produto+"%");
        return query.getResultList();
    }

}
 