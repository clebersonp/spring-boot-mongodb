package br.com.pauluci.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Boolean valido = false;
	private List<Mensagem> mensagens = new ArrayList<>();
	private String protocolo;
	
	public Boolean getValido() {
		return valido;
	}
	public void setValido(Boolean valido) {
		this.valido = valido;
	}
	
	public List<Mensagem> getMensagens() {
		return mensagens;
	}
	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
	
	public String getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
	
	public void add (Mensagem mensagem) {
		this.mensagens.add(mensagem);
	}

	@Override
	public String toString() {
		return "BaseResponse [valido=" + valido + ", mensagens=" + mensagens + ", protocolo=" + protocolo + "]";
	}
}