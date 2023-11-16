package com.att3.Atividade3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.att3.Atividade3.models.CategoriaProduto;
import com.att3.Atividade3.models.Produto;
import com.att3.Atividade3.repository.CategoriaProdutoRepository;
import com.att3.Atividade3.repository.ProdutoRepository;

@SpringBootApplication
public class Atividade3Application {

	@Bean
	public CommandLineRunner init(
		@Autowired ProdutoRepository produtoRepository, 
		@Autowired CategoriaProdutoRepository categoriaProdutoRepository
	){
		return args ->{
			// INSERINDO PRODUTOS

			Produto p1 = new Produto(0, "Cabeçote", 500.900);
			Produto p2 = new Produto(0, "Freio", 50.00);
			Produto p3 = new Produto(0, "Volante", 100.00);
			Produto p4 = new Produto(0, "Roda", 500.0);
			Produto p5 = new Produto(0, "Pneu", 300.0);
		


			System.out.println("Inserir Produto");		
		
			p1 = produtoRepository.save(p1);
			p2 = produtoRepository.save(p2);
			p3 = produtoRepository.save(p3);
			p4 = produtoRepository.save(p4);
			p5 = produtoRepository.save(p5);
			

			
			System.out.println("Selecionar Preço acima do digitado");
			List<Produto> listaProdutos = produtoRepository.findByPrecoProdutos(2000.0);
			listaProdutos.forEach(System.out::println);


			System.out.println("Selecionar igual ou abaixo do digitado");
			listaProdutos = produtoRepository.findByPreco(1000.0);
			listaProdutos.forEach(System.out::println);

			System.out.println("Selecionar todos os produtos por caracteres digitados");
			listaProdutos = produtoRepository.findByNomeLike("%L%");
			listaProdutos.forEach(System.out::println);

			System.out.println("Selecionar todos");
			listaProdutos = produtoRepository.findAll();
			listaProdutos.forEach(System.out::println);

			System.out.println("Adicionar Categoria Produto");
			CategoriaProduto cp1 = new CategoriaProduto(0, "Plantas");
			CategoriaProduto cp2 = new CategoriaProduto(0, "Animais");
			CategoriaProduto cp3 = new CategoriaProduto(0, "Móveis");

			cp1 = categoriaProdutoRepository.save(cp1);
			cp2 = categoriaProdutoRepository.save(cp2);
			cp3 = categoriaProdutoRepository.save(cp3);

			listaProdutos.get(0).setCategoriaProduto(cp1);
			produtoRepository.save(listaProdutos.get(0));

			listaProdutos.get(1).setCategoriaProduto(cp1);
			produtoRepository.save(listaProdutos.get(1));

			listaProdutos.get(2).setCategoriaProduto(cp1);
			produtoRepository.save(listaProdutos.get(2));

			// // // Adicionando categoria Animais
			listaProdutos.get(3).setCategoriaProduto(cp2);
			produtoRepository.save(listaProdutos.get(3));

			listaProdutos.get(4).setCategoriaProduto(cp2);
			produtoRepository.save(listaProdutos.get(4));

			listaProdutos.get(5).setCategoriaProduto(cp2);
			produtoRepository.save(listaProdutos.get(5));

			System.out.println("Selecionar todas as categorias por caracteres digitados");
			List<CategoriaProduto> listaCategorias = categoriaProdutoRepository.findByNameStartingWith("A");
			listaCategorias.forEach(System.out::println);

			System.out.println("Produtos relacionado a uma determinada categoria");
			CategoriaProduto cp = categoriaProdutoRepository.findCategoriaProdutoFetchProduto(2);
			System.out.println(cp.getProdutos().toString());

		};
	};

	public static void main(String[] args) {
		SpringApplication.run(Atividade3Application.class, args);
	}

}
