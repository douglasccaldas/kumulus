package com.kumulus.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kumulus.desafio.exception.NegocioException;
import com.kumulus.desafio.model.Pessoa;
import com.kumulus.desafio.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
    private PessoaRepository pessoaRepository;
 
    public List<Pessoa> obterTodasAsPessoas() {
        return pessoaRepository.obterTodasAsPessoasComEnderecos();
    }

    public Pessoa obterPessoaPorId(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public Pessoa salvarPessoa(Pessoa pessoa) {
    	if(null == pessoa.getId() && pessoaComMesmoNomeJaExiste(pessoa.getNome())){
    		  throw new NegocioException("Já existe uma pessoa cadastrada o mesmo nome.");
    	}
    	
       return pessoaRepository.save(pessoa);
    }

    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
    
    public boolean pessoaComMesmoNomeJaExiste(String nome) {
        Optional<Pessoa> pessoaExistente = pessoaRepository.findByNome(nome);
        return pessoaExistente.isPresent();
    }
}
