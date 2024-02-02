package com.controle.estoque.estoque.controller;

import com.controle.estoque.estoque.entity.EstoqueEntity;
import com.controle.estoque.estoque.repository.EstoqueRepository;
import com.controle.estoque.estoque.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("estoque")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public List <EstoqueEntity> getAll(){
        List<EstoqueEntity> listaEstoque = estoqueRepository.findAll(); //retorna uma lista de entidades.
        return listaEstoque;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getEstoque(@PathVariable("id") Long id){
        EstoqueEntity produtoEncontrado = estoqueService.consultarProdutoPorId(id);
        if (produtoEncontrado != null) {
            return ResponseEntity.ok(produtoEncontrado);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Object> cadastrarProduto(@RequestBody EstoqueEntity estoque){
        EstoqueEntity produtoCadastradoComSucesso = estoqueService.cadastrarProduto(estoque);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCadastradoComSucesso);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletarProduto(@PathVariable long id){
        boolean produtoDeletado = estoqueService.deletarProduto(id);
        if (produtoDeletado) {
            return ResponseEntity.noContent().build(); // Retorna status 204 No Content = sem conteudo
        } else {
            return ResponseEntity.notFound().build(); // Retorna status 404 Not Found = produto não encontrado
        }
    }
}
