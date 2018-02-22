package br.com.pauluci.client.model;

import java.io.Serializable;

public class Filial implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private FilialPK filialPK;
	private String razaoSocial;
	private String cnpj;

	public Filial() {
	}
	public Filial(FilialPK filialPK) {
		this.filialPK = filialPK;
	}

	public FilialPK getFilialPK() {
		return filialPK;
	}
	public void setFilialPK(FilialPK filialPK) {
		this.filialPK = filialPK;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "Filial [filialPK=" + filialPK + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + "]";
	}
}