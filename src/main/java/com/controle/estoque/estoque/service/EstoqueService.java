package com.controle.estoque.estoque.service;

import com.controle.estoque.estoque.entity.EstoqueEntity;
import com.controle.estoque.estoque.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public EstoqueEntity consultarProdutoPorId(Long id){
        Optional<EstoqueEntity> estoque = estoqueRepository.findById(id);
        return estoque.orElse(null);
    }

    public EstoqueEntity cadastrarProduto(EstoqueEntity novoProduto){
        EstoqueEntity produtoCadastrado = estoqueRepository.save(novoProduto);
        return produtoCadastrado;
    }

    public boolean deletarProduto(long id){
        if (estoqueRepository.existsById(id)) {
            estoqueRepository.deleteById(id);
            return true; // Produto deletado com sucesso
        } else {
            return false; // Produto não encontrado
        }
    }
}
