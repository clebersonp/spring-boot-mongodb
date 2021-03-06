package br.com.pauluci.endpoint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pauluci.model.Filial;
import br.com.pauluci.model.FilialPK;

@RestController
@RequestMapping("/filiais")
public class FilialEndpoint {

	@GetMapping("/{empresa}/{codigo}")
	public ResponseEntity<DtoResponse<Filial>> recuperar() {
		
		Integer i = new Integer(10);
		DtoResponse<Filial> response = new DtoResponse<>();
		response.setProtocolo("API");
		
		if (i % 2 == 0) {
			Mensagem mensagem = new Mensagem();
			mensagem.setCodigo("0");
			mensagem.setMensagem("Filial não encontrada.");
			response.addMsg(mensagem);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		
		Filial filial = this.getFilialFake();
		response.addDto(filial);
		response.setValido(Boolean.TRUE);
		
		return ResponseEntity.ok().body(response);
	}

	private Filial getFilialFake() {
		Filial filial = new Filial(new FilialPK(10, 10));
		filial.setCnpj("11111111111111");
		filial.setRazaoSocial("Empresa LTDA");
		return filial;
	}
}