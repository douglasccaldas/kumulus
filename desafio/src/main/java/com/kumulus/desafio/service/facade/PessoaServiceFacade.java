package com.kumulus.desafio.service.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kumulus.desafio.model.Endereco;
import com.kumulus.desafio.model.Pessoa;
import com.kumulus.desafio.service.CepService;
import com.kumulus.desafio.service.EnderecoService;
import com.kumulus.desafio.service.PessoaService;
import com.kumulus.desafio.util.StringUtils;


@Service
public class PessoaServiceFacade {

	@Autowired
    private PessoaService pessoaService;
	@Autowired
    private CepService cepService;
	@Autowired
    private EnderecoService enderecoService;

 
    public List<Pessoa> obterTodasAsPessoas() {
        return pessoaService.obterTodasAsPessoas();
    }
    
    public Endereco consultarEnderecoPorCep(String cep) {
        return cepService.consultarCep(cep);
    }

    public Pessoa obterPessoaPorId(Long id) {
        return pessoaService.obterPessoaPorId(id);
    }

    public void salvarPessoa(Pessoa pessoa) {    	
    	
    	Pessoa pessoaPersistida = pessoaService.salvarPessoa(pessoa);

    	Optional.ofNullable(pessoa.getEnderecos())
        .ifPresent(lista -> lista.forEach(endereco -> {
            if (endereco != null && endereco.getCep() != null) {
                endereco.setCep(StringUtils.removerFormatacaoCep(endereco.getCep()));
                endereco.setPessoa(pessoaPersistida);
                enderecoService.salvarEndereco(endereco);
            }
        }));
        
    }

    public void deletarPessoa(Long id) {
    	pessoaService.deletarPessoa(id);
    }
}
