package br.com.pauluci.endpoint;

import java.util.ArrayList;
import java.util.List;

public class DtoResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	private List<Object> dtos = new ArrayList<>();
	
	public List<Object> getDtos() {
		return dtos;
	}
	public void setDtos(List<Object> dtos) {
		this.dtos = dtos;
	}

	public void add (Object obj) {
		this.dtos.add(obj);
	}
	
	@Override
	public String toString() {
		return "DtoResponse [dtos=" + dtos + "]";
	}
}