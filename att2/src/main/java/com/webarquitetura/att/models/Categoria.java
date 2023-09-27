package com.webarquitetura.att.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_categoria")
public class Categoria {

    
    public Categoria(Long id_categoria, String nome) {
        this.id_categoria = id_categoria;
        this.nome = nome;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;
    private String nome;
    

    public Categoria() {
        
    }


    public Long getId_categoria() {
        return id_categoria;
    }


    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
