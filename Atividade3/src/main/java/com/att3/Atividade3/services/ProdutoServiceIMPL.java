package com.att3.Atividade3.services;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.att3.Atividade3.dtos.CategoriaProdutoDTO;
import com.att3.Atividade3.dtos.DadosProdutoDTO;
import com.att3.Atividade3.dtos.ProdutoDTO;
import com.att3.Atividade3.exceptions.RegraNegociosExceptions;
import com.att3.Atividade3.models.Produto;
import com.att3.Atividade3.repository.CategoriaProdutoRepository;
import com.att3.Atividade3.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public interface ProdutoServiceIMPL implements ProdutoServices {
    
    private final ProdutoRepository produtoRepository;
    private final CategoriaProdutoRepository categoriaProdutoRepository;
    
    @Override
    public Produto salvar(ProdutoDTO produtoDTO) {
        CategoriaProduto categoriaProduto = categoriaProdutoRepository.findById(
            produtoDTO.getId_categoriaProd()).orElseThrow(
                () -> new RegraNegocioException("Código da categoria não foi encontrado!")
        );

        Produto p = new Produto();
        p.setCategoriaProduto(categoriaProduto);
        p.setNome(produtoDTO.getNome());
        p.setPreco(produtoDTO.getPreco());

        return produtoRepository.save(p);
    }

    @Override
    public List<ProdutoDTO> listAll() {
        List<ProdutoDTO> produtos = produtoRepository.findAll().stream().map(
            (Produto p) -> {
                return ProdutoDTO.builder()
                .id(p.getId())
                .nome(p.getNome())
                .preco(p.getPreco())
                .id_categoriaProd(p.getCategoriaProduto() != null ? p.getCategoriaProduto().getId_categoria(): 0)
                .build();
            }
        ).collect(Collectors.toList());

        return produtos;
    }

    @Override
    public DadosProdutoDTO obtainById(Integer id) {
        return produtoRepository.findById(id).map(
            (Produto p) -> {
                return 
                    DadosProdutoDTO.builder()
                    .id(p.getId())
                    .nome(p.getNome())
                    .preco(p.getPreco())
                    .categoria(
                        p.getCategoriaProduto() != null ?
                        CategoriaProdutoDTO.builder()
                        .id_categoria(p.getCategoriaProduto().getId_categoria())
                        .name(p.getCategoriaProduto().getName())
                        .build() : null
                ).build();
            }
        ).orElseThrow(
            () -> new RegraNegocioException("Produto não encontrado com o ID Fornecido!")
        );
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public void update(Integer id, ProdutoDTO dto) {
        Produto produto = produtoRepository.findById(id).orElseThrow(
            () -> new RegraNegocioException("Código usuário não encontrado."));

        CategoriaProduto categoriaProduto = categoriaProdutoRepository.findById(dto.getId_categoriaProd())
        .orElseThrow(
            () -> new RegraNegocioException("Categoria não Encontrada.")
        );

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setCategoriaProduto(categoriaProduto);
        produtoRepository.save(produto);
    }
}   


