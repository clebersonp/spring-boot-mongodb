package br.com.pauluci.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.pauluci.exceptions.ServiceException;
import br.com.pauluci.model.Usuario;
import br.com.pauluci.repository.UsuarioRepository;
import br.com.pauluci.service.UsuarioServiceI;

@Service
public class UsuarioServiceImpl implements UsuarioServiceI {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public void salvar(Usuario usuario) throws ServiceException {
		
		Usuario save = repository.save(usuario);
		
		if (save != null) {
			throw new ServiceException("Usuario não foi salvo com sucesso!", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public List<Usuario> listar() throws ServiceException {
		return repository.findAll();
	}

	public void atualizar(Usuario usuario) throws ServiceException {
		
		Usuario save = repository.save(usuario);
		
		if (save == null) {
			throw new ServiceException("Usuario não foi alterado com sucesso!", HttpStatus.BAD_REQUEST);
		}
	}
}