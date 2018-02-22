package br.com.pauluci.model;

import java.io.Serializable;

public class FilialPK implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer empresa;
	private Integer codigo;
	
	public FilialPK() {
	}

	public FilialPK(Integer empresa, Integer codigo) {
		this.empresa = empresa;
		this.codigo = codigo;
	}

	public Integer getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "FilialPK [empresa=" + empresa + ", codigo=" + codigo + "]";
	}
}