package br.com.pauluci.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pauluci.model.Usuario;

@RestController
@RequestMapping(value = "/index")
public class IndexController {

	@GetMapping
	public String index() {
		return "Hello World!";
	}
	
	@GetMapping(value = "nome/{nome}")
	public String index(@PathVariable(name = "nome") final String nome) {
		String nomeMaiusculo = nome != null ? nome.toUpperCase() : nome;
		return "Welcome Mrs. " + nomeMaiusculo;
	}
	
	@PostMapping(value = "/criar/usuario")
	public ResponseEntity<ResponseDefault> criarUsuario(@RequestBody final Usuario usuario ) {
		ResponseDefault response = new ResponseDefault();
		
		if (usuario != null && usuario.getNome().equalsIgnoreCase("cleberson")) {
			response.setCodigoHttp(HttpStatus.OK.value());
			response.setMensagem("Usuario criado com sucesso!");
			return ResponseEntity.ok(response);
		} 
		response.setCodigoHttp(HttpStatus.BAD_REQUEST.value());
		response.setMensagem("Usuario nao foi criado com sucesso!");
		response.add(new ErroDefault("Erro no banco de dados!", this.getClass().getName()));
		return ResponseEntity.badRequest().body(response);
	}
}
