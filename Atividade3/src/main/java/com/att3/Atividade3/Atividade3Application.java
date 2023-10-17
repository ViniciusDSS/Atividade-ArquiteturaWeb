package com.att3.Atividade3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.att3.Atividade3.repository.CategoriaProdutoRepository;
import com.att3.Atividade3.repository.ProdutoRepository;

@SpringBootApplication
public class Atividade3Application {

	@Bean
	public CommandLineRunner init(
				@Autowired ProdutoRepository produtoRepository,
				@Autowired CategoriaProdutoRepository categoriaProdutoRepository)
		return arg -> {
			produtoRepository.save(
				new Produto ((Integer)0, "test", 10));
				
			)

			
		}
	

	public static void main(String[] args) {
		SpringApplication.run(Atividade3Application.class, args);
	}

}
