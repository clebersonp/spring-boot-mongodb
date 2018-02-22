package br.com.pauluci.client;

import java.io.Serializable;

public class Mensagem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String mensagem;

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return "Mensagem [codigo=" + codigo + ", mensagem=" + mensagem + "]";
	}
}