package com.att3.Atividade3.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome; 
    @OneToMany(mappedBy = "categoria")
    private List<Produto> produto;

    public Categoria() {

    }

    public Categoria(Integer id, String nome, List<Produto> produto) {
        this.id = id;
        this.nome = nome;
        this.produto = produto;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Produto> getProduto() {
        return produto;
    }
    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
    @Override
    public String toString() {
        return "Categoria [id=" + id + ", nome=" + nome + ", produto=" + produto + "]";
    }

}
