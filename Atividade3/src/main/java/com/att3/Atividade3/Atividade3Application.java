package com.att3.Atividade3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.att3.Atividade3.models.Produto;
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
			produtoRepository.save(
				new Produto ((Integer)0, "test2", 15));
		List<Produto> listaProduto = produtoRepository.findAll();
		listaProduto.forEach(System.out::println);		
			
		System.out.println("----------Obter por Nome----------");
		listaProduto.produtoRepository.findByNomeLike("%2%");
		listaProduto.forEach(System.out::println);

		System.out.println("--------- Inserir categoria-------");
		CategoriaProduto c1 = new CategoriaProduto(null "tenis");
		produtoRepository.save(c1);
		
		System.out.println("------ Atualizar Categoria-----------");
		listaProduto.get(0);setCategoriaProduto(c1);
		produtoRepository.save(listaProduto.get(0));

		System.out.println("------- FETCH --------");
		CategoriaProduto cc = categoriaProdutoRepository.findCategoriaFetchProduto((Integer)1);
		System.out.println(cc.getProduto().size());	

			
		};	
 }

	public static void main(String[] args) {
		SpringApplication.run(Atividade3Application.class, args);
	}

}
