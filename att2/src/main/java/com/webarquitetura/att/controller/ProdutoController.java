package com.webarquitetura.att.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.webarquitetura.att.models.Produto;
import com.webarquitetura.att.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> findAll(){
       return produtoRepository.findAll();
    }

    @GetMapping(value = "precomaior")
    public List<Produto> findProdutosComPrecoMaiorQue(Double valor) {
    return produtoRepository.findByPrecoGreaterThan(valor);
  }

    @GetMapping(value = "/{id}")
    public Produto findById(@PathVariable Long id){
       Optional<Produto> optionalProduto = produtoRepository.findById(id);
       return optionalProduto.orElse(null); // resposta de erro apropriada
    }
}
