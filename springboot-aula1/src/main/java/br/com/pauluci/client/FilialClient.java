package br.com.pauluci.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.pauluci.client.model.Filial;

@RestController
@SuppressWarnings("rawtypes")
public class FilialClient {
	
	private static final String RECUPERAR = "http://localhost:8080/filiais/{empresa}/{codigo}";
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	public Filial recuper(Integer empresa, Integer codigo) {
		
		Map<String , Integer> params = new HashMap<>();
		params.put("empresa", empresa);
		params.put("codigo", codigo);
		
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<DtoResponse> response = restTemplate.getForEntity(RECUPERAR, DtoResponse.class, params);
			DtoResponse dto = response.getBody();
			
		
			if (dto.getValido()) {
				DtoResponse<Filial> dtoParser = MAPPER.convertValue(dto, new TypeReference<DtoResponse<Filial>>(){});
				Filial filial = dtoParser.getDtos().get(0);
				return filial;
			}
		} catch (RestClientException e) {
			System.out.println(e);
		}
		return null;
	}
}