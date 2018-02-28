package br.com.pauluci.model;

public class Avatar {
	private String contentType;
	private Long size;
	private byte[] arquivo;
	
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}

	public byte[] getArquivo() {
		return arquivo;
	}
	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}
}