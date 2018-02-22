package br.com.pauluci.endpoint;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErroDefault implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("description")
	private String descricao;
	
	@JsonProperty("date-time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd kk:mm:ss")
	private LocalDateTime dataHora;

	public ErroDefault() {}
	
	public ErroDefault(String descricao, LocalDateTime dataHora) {
		this.descricao = descricao;
		this.dataHora = dataHora;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
}