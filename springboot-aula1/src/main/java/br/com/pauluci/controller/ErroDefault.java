package br.com.pauluci.controller;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErroDefault implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public ErroDefault() {}
	
	public ErroDefault(String descricao, String stack) {
		this.descricao = descricao;
		this.stack = stack;
	}

	@JsonProperty("description")
	private String descricao;
	
	@JsonProperty("stack-trace")
	private String stack;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStack() {
		return stack;
	}
	public void setStack(String stack) {
		this.stack = stack;
	}
}