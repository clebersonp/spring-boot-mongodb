package br.com.pauluci.service;

import java.util.List;

import br.com.pauluci.exceptions.ServiceException;
import br.com.pauluci.model.Usuario;

public interface UsuarioServiceI {
	void salvar(Usuario usuario) throws ServiceException;
	void atualizar(Usuario usuario) throws ServiceException;
	List<Usuario> listar() throws ServiceException;
}