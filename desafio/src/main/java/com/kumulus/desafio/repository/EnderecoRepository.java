package com.kumulus.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kumulus.desafio.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    // Métodos de consulta personalizados, se necessário
}
