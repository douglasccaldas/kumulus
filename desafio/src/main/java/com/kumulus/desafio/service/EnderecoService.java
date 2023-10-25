package com.kumulus.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kumulus.desafio.model.Endereco;
import com.kumulus.desafio.repository.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;

    
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> obterTodosOsEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco obterEnderecoPorId(Long id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    public void salvarEndereco(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public void deletarEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
}
