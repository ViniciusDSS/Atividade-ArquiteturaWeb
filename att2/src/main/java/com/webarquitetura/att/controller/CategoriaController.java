package com.webarquitetura.att.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webarquitetura.att.models.Categoria;
import com.webarquitetura.att.repository.CategoriaProdutoRepository;

@RestController
@RequestMapping(value = "/Categoria")
public class CategoriaController {
    
     @Autowired
     private CategoriaProdutoRepository categoriaProdutoRepository;


     @GetMapping
public List<Categoria> findAllCategories(){
   return categoriaProdutoRepository.findAll();
}

@GetMapping(value = "/{id}")
public Categoria findCategoryById(@PathVariable Long id){
   Optional<Categoria> optionalCategoria = categoriaProdutoRepository.findById(id);
   return optionalCategoria.orElse(null); // Ou uma resposta de erro apropriada
}
}
