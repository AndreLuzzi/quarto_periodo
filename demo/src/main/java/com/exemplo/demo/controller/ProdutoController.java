package com.exemplo.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.demo.model.Produto;
import com.exemplo.demo.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
    public class ProdutoController {

    private final ProdutoRepository repository;
    
    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }
    
    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return repository.save(produto);
    }
}
