package com.kumulus.desafio.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class BaseBean implements Serializable {

	private static final long serialVersionUID = 6366886302007798815L;
	
	protected void adicionarMensagemSucesso() {
		FacesMessage mensagemSucesso = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso",
				"Ação realizada com sucesso!");
		FacesContext.getCurrentInstance().addMessage("msgs", mensagemSucesso);
	}
	
	protected void adicionarMensagemErro() {
		adicionarMensagemErro(null);
	}

	protected void adicionarMensagemErro(String msg) {
		FacesMessage mensagemFalha = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha",
				msg == null ? "Ação falhou! Verifique os dados e tente novamente." : msg);
		FacesContext.getCurrentInstance().addMessage("msgs", mensagemFalha);
	}
}
