package com.webarquitetura.att;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.webarquitetura.att.models.Categoria;
import com.webarquitetura.att.models.Produto;
import com.webarquitetura.att.repository.CategoriaProdutoRepository;
import com.webarquitetura.att.repository.ProdutoRepository;

@SpringBootApplication
public class AttApplication {

    @Autowired ProdutoRepository repository;
    @Autowired CategoriaProdutoRepository caterepository;

    @Bean
    public CommandLineRunner init() {
        return args -> {

            List<Produto> listaProdutos = repository.findAll();
			listaProdutos.forEach(System.out::println);

            repository.save(
					new Produto((long) 6, "bone", 20.00));
			repository.save(
					new Produto((long) 7, "meias", 10.99));

            System.out.println("--------- Valor maior que 20---------");
            listaProdutos = repository.findByPrecoGreaterThan(20.0);
            listaProdutos.forEach(System.out::println);

            System.out.println("--------- Valor menor que 50---------");
            repository.findByPrecoLessThan(50.0);


            repository.findByNomeLike("relogio");

            caterepository.findByNome("relogio");
            caterepository.findByIdWithProduto((long) 2);

            
			System.out.println("** Retorna uma categoria pelo ID e todos os produtos relacionados **");
			Categoria cc2 = caterepository.findCategoriaFetchProduto((long) 1);
            System.out.println(cc2.getProduto().size());

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(AttApplication.class, args);
    }
}