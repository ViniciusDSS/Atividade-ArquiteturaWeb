package com.webarquitetura.att.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webarquitetura.att.models.Produto;
import com.webarquitetura.att.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/Produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> findAll(){
       List<Produto> result = produtoRepository.findAll();
       return result;
    }

    @GetMapping(value = "/{id}")
    public Produto findById(@PathVariable Long id){
       Produto result = produtoRepository.findById(id).get();
       return result;
    }
    
}
