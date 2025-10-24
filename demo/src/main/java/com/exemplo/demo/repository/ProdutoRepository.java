package com.exemplo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.demo.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    
}

