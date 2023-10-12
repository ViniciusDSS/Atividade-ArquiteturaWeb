package com.att3.Atividade3.services;

import org.springframework.stereotype.Service;

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
        retunr produtoRepository.save(p);
}
