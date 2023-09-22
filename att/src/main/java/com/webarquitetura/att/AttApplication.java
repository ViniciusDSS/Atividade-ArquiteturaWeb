package com.webarquitetura.att;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.webarquitetura.att.models.Produto;
import com.webarquitetura.att.repository.ProdutoRepository;

@SpringBootApplication
public class AttApplication {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Bean
    public CommandLineRunner init() {
        return args -> {

            produtoRepository.inserir(new Produto(1, "teste", 10));
            produtoRepository.inserir(new Produto(2, "teste2", 14));
            List<Produto> listProduto = produtoRepository.consultarProdutos();
            listProduto.forEach(System.out::println);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(AttApplication.class, args);
    }
}