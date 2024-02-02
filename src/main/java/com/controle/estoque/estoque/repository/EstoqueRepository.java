package com.controle.estoque.estoque.repository;

import com.controle.estoque.estoque.entity.EstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository <EstoqueEntity, Long> {
}
