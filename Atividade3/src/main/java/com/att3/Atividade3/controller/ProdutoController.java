package com.att3.Atividade3.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.att3.Atividade3.dtos.DadosProdutoDTO;
import com.att3.Atividade3.dtos.ProdutoDTO;
import com.att3.Atividade3.models.Produto;
import com.att3.Atividade3.services.ProdutoServices;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    
    private ProdutoServices produtoServices;

    public ProdutoController(ProdutoServices produtoServices) {
        this.produtoServices = produtoServices;
    } 
    
 @PostMapping
 @ResponseStatus(HttpStatus.CREATED)
 public Integer inserir(@RequestBody ProdutoDTO produtoDTO){
    return produtoServices.salvar(produtoDTO).getId();
 }   
    
 @GetMapping("{id}")
 public DadosProdutoDTO obterPorId(@PathVariable Integer id) {  
        return produtoServices.obterPorId(id); 
}

@GetMapping
public List<ProdutoDTO> listarTodos() {
    return produtoServices.listarTodos();
}

@DeleteMapping("{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void delet(@PathVariable Integer id) {
    produtoServices.excluir(id);
}

@PutMapping("{id}")
public void edit(@PathVariable Integer id, @RequestBody ProdutoDTO dto){
    produtoServices.editar(id, dto);
    } 
}