package br.com.pauluci.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.pauluci.endpoint.ErroDefault;
import br.com.pauluci.endpoint.ResponseDefault;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(value = ServiceException.class)
	public ResponseEntity<ResponseDefault> serviceException(ServiceException e, HttpServletRequest request) {
		ResponseDefault response = new ResponseDefault();
		response.setCodigoHttp(e.getStatus().value());
		response.setMensagem("Falha no serviço");
		response.add(new ErroDefault(e.getMessage(), LocalDateTime.now()));
		return ResponseEntity.status(e.getStatus().value()).body(response); 
	}
}