package com.att3.Atividade3.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.att3.Atividade3.dtos.CategoriaProdutoDTO;
import com.att3.Atividade3.dtos.DadosProdutoDTO;
import com.att3.Atividade3.dtos.ProdutoDTO;
import com.att3.Atividade3.exceptions.RegraNegociosExceptions;
import com.att3.Atividade3.models.Produto;
import com.att3.Atividade3.repository.CategoriaProdutoRepository;
import com.att3.Atividade3.repository.ProdutoRepository;

@Service
@RequiredArgsConstructor
public interface ProdutoServiceIMPL implements ProdutoServices {
    
    private final ProdutoRepository produtoRepository;
    private final CategoriaProdutoRepository categoriaProdutoRepository;

    @Override
    public Produto salvar (ProdutoDTO produtoDTO) {  
        categoriaProduto categ = categoriaProdutoRepository.findByid(
                produtoDTO.getCategoriaProdutoDTOId()).orElseThrow(
                    () -> new RegraNegocioException("Codigo da categoria não encontrado."));

        Produto p = new Produto();
        p.setNome(produtoDTO.getNome());
        p.setPreco(produtoDTO.getPreco())
        return produtoRepository.save(p);
    }

    public List<ProdutoDTO> listarTodos() {
        List<ProdutoDTO> produto = produtoRepository.findAll().stream().map(
            (Produto p) -> {
                return ProdutoDTO.builder()
                                 .id(p.getId())
                                 .name(p.getNome())
                                 .preco(p.getPreco())
                                 .categoriaProdutoId(p.getCategoriaProduto() == null ? 0
                                                                            : p.getCategoriaProduto().getId())
                                 .build();                                                                             
                    }).collect(Collectors.toList());
            return produto;
    }

    @Override
    public DadosProdutoDTO obterPorId(Integer id) {
        return produtoRepository.findById(id).map((Produto p) ->{
            return ProdutoDTO.builder()
                             .Id(p.getId())
                             .name(p.getNome())
                             .preco(p.getPreco())
                             .categoria(p.getCategoriaProduto() != null ? CategoriaProdutoDTO.builder()
                                         .id(p.getCategoriaProduto().getId())
                                         .nome(p.getCategoriaProduto().getNome())
                                         .build() : null)
                            .build();
                })
                            .orElseThrow(
                                () -> new RegraNegociosExceptions("Id do Produto não encontrado"));
                                  
        }
    
    @Override
    public void excluir(Integer id) {
        produtoRepository.deleteById(id);
    }
    
    @Override
    public void editar(Integer id, ProdutoDTO dta) {
        Produto produto = produtoRepository.findById(id);
                           .orElseThrow(() -> new RegraNegociosExceptions("Produto não encontrado"));
   
        CategoriaProduto categoriaProduto = categoriaProdutoRepository.findById(dto.getCategoriaProdutoId())
                         .orElseThrow(() -> new RegraNegociosExceptions("Categoria não encontrado"));
                         
                         produto.setNome(dto.getNome());
                         produto.setPreco(dto.getPreco());
                         produto.setCategoriaProduto(categoriaProduto);
                         produtoRepository.save(produto);

                    }
        
}   


