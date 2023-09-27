package com.webarquitetura.att;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.webarquitetura.att.repository.CategoriaProdutoRepository;
import com.webarquitetura.att.repository.ProdutoRepository;

@SpringBootApplication
public class AttApplication {

    @Autowired ProdutoRepository repository;
    @Autowired CategoriaProdutoRepository caterepository;

    @Bean
    public CommandLineRunner init() {
        return args -> {

            repository.findByPrecoGreaterThan(20.0);
            repository.findByPrecoLessThan(50.0);
            repository.findByNome("relogio");

            caterepository.findByNome("relogio");

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(AttApplication.class, args);
    }
}