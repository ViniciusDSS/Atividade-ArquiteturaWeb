package com.webarquitetura.att.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
public class Produto {
    
    public Produto(Long id_produto, String prod_nome, Double prod_preco, Categoria categorias) {
        this.id_produto = id_produto;
        this.prod_nome = prod_nome;
        this.preco = prod_preco;
        this.categorias = categorias;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produto;
    private String prod_nome;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categorias;

    public Produto(){
        
    }

    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    public String getProd_nome() {
        return prod_nome;
    }

    public void setProd_nome(String prod_nome) {
        this.prod_nome = prod_nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double prod_preco) {
        this.preco = prod_preco;
    }

    public Categoria getCategorias() {
        return categorias;
    }

    public void setCategorias(Categoria categorias) {
        this.categorias = categorias;
    }

    
   
    }


