package com.kumulus.desafio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kumulus.desafio.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("SELECT DISTINCT p FROM Pessoa p LEFT JOIN FETCH p.enderecos")
    List<Pessoa> obterTodasAsPessoasComEnderecos();

	Optional<Pessoa> findByNome(String nome);

}

