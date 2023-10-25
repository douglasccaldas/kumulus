package com.kumulus.desafio.bean;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kumulus.desafio.enums.SituacaoEnum;
import com.kumulus.desafio.exception.NegocioException;
import com.kumulus.desafio.model.Endereco;
import com.kumulus.desafio.model.Pessoa;
import com.kumulus.desafio.service.facade.PessoaServiceFacade;
import com.kumulus.desafio.util.Constantes;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Component
@ManagedBean
@ViewScoped
public class PessoaBean extends BaseBean  {
	private static final long serialVersionUID = 6732943635890529863L;

	@Autowired
	private PessoaServiceFacade service;
	private Pessoa formPessoa;
	private Endereco formEndereco;
	private List<Pessoa> pessoas;

	public PessoaBean() {
	}

	@PostConstruct
	public void initForm() {
		this.listarPessoas();
		this.limparFormulario();
	}

	public void limparFormulario() {
		formPessoa = new Pessoa();
		formEndereco = new Endereco();
	}

	public void consultarEndereco() {
		formEndereco = service.consultarEnderecoPorCep(formEndereco.getCep());
	}

	private void listarPessoas() {
		this.pessoas = service.obterTodasAsPessoas();
	}

	public void salvarPessoa() {
		try {
			service.salvarPessoa(formPessoa);
			adicionarMensagemSucesso();
		} catch (NegocioException e) {
			adicionarMensagemErro(e.getMessage());
		} catch (Exception e) {
			adicionarMensagemErro();
		}
		initForm();
	}

	public void salvarEndereco() {
		if (formEndereco.getId() == null) {
			formPessoa.getEnderecos().add(formEndereco);
		} else {
			formPessoa.getEnderecos().stream().filter(e -> e.getId().equals(formEndereco.getId())).findFirst()
					.ifPresent(e -> {
						e.setCep(formEndereco.getCep());
						e.setUf(formEndereco.getUf());
						e.setLocalidade(formEndereco.getLocalidade());
						e.setBairro(formEndereco.getBairro());
						e.setLogradouro(formEndereco.getLogradouro());
						e.setNumero(formEndereco.getNumero());
						e.setComplemento(formEndereco.getComplemento());
					});
		}
		this.formEndereco = new Endereco();

	}

	public void alterarSituacaoEndereco(Endereco enderecoAlt) {
		if (enderecoAlt.getSituacao() == SituacaoEnum.A) {
			enderecoAlt.setSituacao(SituacaoEnum.I);
		} else {
			enderecoAlt.setSituacao(SituacaoEnum.A);
		}
	}

	public void carregarEndereco(Endereco endereco) {
		formEndereco = endereco;
	}

	public void visualizarPessoa(Pessoa pessoa) {
		this.formPessoa = pessoa;
	}

	public String getDataNascimentoFormatada() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(this.formPessoa.getDtNascimento());
	}

	public void fecharModalVisualizar() {
		this.formPessoa = new Pessoa();
	}

	public void carregarPessoa(Pessoa pessoa) {
		this.formPessoa = pessoa;
	}

	public void prepararNovoEndereco() {
		this.formEndereco = new Endereco();
	}

	public void prepararExclusao(Pessoa pessoa) {
		this.formPessoa = pessoa;
	}

	public void excluirPessoa() {
		try {
			service.deletarPessoa(formPessoa.getId());
			adicionarMensagemSucesso();
		} catch (Exception e) {
			adicionarMensagemErro();
		}
		initForm();
	}

	// Método para obter a lista de estados para a combo de estados
	public List<String> getEstados() {
		return Constantes.UFs;
	}
}