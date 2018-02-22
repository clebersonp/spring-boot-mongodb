package br.com.pauluci.client;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

// referencia: https://github.com/FasterXML/jackson-databind/issues/921
@JsonPropertyOrder({ "valido", "mensagens", "protocolo", "dtos" })
public class DtoResponse<T> extends BaseResponse {

	private static final long serialVersionUID = 1L;
	private List<T> dtos = new ArrayList<>();

	private DtoResponse(List<T> dtos) {
		this.dtos = dtos;
	}

	public DtoResponse() {
	}
	
	@JsonCreator
	public static <T> DtoResponse<T> create(@JsonProperty("dtos") List<T> dtos) {
		return new DtoResponse.Builder<T>().comDados(dtos).build();
	}

	public static class Builder<T> {
		private List<T> dtos;

		public Builder<T> comDados(List<T> dtos) {
			this.dtos = dtos;
			return this;
		}

		public DtoResponse<T> build() {
			return new DtoResponse<T>(dtos);
		}
	}

	public List<T> getDtos() {
		return dtos;
	}

	public void setDtos(List<T> dtos) {
		this.dtos = dtos;
	}

	public void addDto(T obj) {
		this.dtos.add(obj);
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "DtoResponse [dtos=" + dtos + "]";
		}
	}
}