package br.com.pauluci.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pauluci.model.Usuario;
import br.com.pauluci.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioEndpoint {

	@Autowired
	private UsuarioServiceImpl usuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		return ResponseEntity.ok(this.usuarioService.listar());
	}

	@PostMapping
	public ResponseEntity<ResponseDefault> criar(@RequestBody final Usuario usuario) {
		
		usuarioService.salvar(usuario);
		
		ResponseDefault response = new ResponseDefault();
		response.setCodigoHttp(HttpStatus.OK.value());
		response.setMensagem("Usuario criado com sucesso!");
		return ResponseEntity.ok(response);
	}
	
	@PutMapping
	public ResponseEntity<ResponseDefault> atualizar(@RequestBody final Usuario usuario) {
		usuarioService.atualizar(usuario);
		
		ResponseDefault response = new ResponseDefault();
		response.setCodigoHttp(HttpStatus.OK.value());
		response.setMensagem("Usuario alterado com sucesso!");
		return ResponseEntity.ok(response);
	}
}