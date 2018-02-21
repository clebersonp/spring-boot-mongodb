package br.com.pauluci.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDefault implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("status-code")
	private Integer codigoHttp;

	@JsonProperty("message")
	private String mensagem;
	
	@JsonProperty("errors")
	private List<ErroDefault> erros = new ArrayList<>();

	public Integer getCodigoHttp() {
		return codigoHttp;
	}
	public void setCodigoHttp(Integer codigoHttp) {
		this.codigoHttp = codigoHttp;
	}

	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<ErroDefault> getErros() {
		return erros;
	}
	public void setErros(List<ErroDefault> erros) {
		this.erros = erros;
	}
	
	public void add(ErroDefault erro) {
		this.erros.add(erro);
	}
}