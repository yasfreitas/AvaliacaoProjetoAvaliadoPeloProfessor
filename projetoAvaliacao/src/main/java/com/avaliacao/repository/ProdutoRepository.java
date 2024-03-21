package com.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
