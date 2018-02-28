package br.com.pauluci.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import br.com.pauluci.exceptions.ServiceException;
import br.com.pauluci.model.Avatar;
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

	public void adicionarAvatar(String id, MultipartFile avatar) {
		Usuario usuario = repository.findOne(id);
		System.out.println(avatar);
		if (Optional.ofNullable(usuario).isPresent()) {
			String arquivoBase64 = null;
			long size2 = 0L;
			long size = avatar.getSize();
			if (size > 1024L) {
				size2 = size / 1024L;
			}
			System.out.println(size2 + " KB");
			String contentType = avatar.getContentType();
			System.out.println(contentType);
			byte[] bytesArquivo = null;
			try {
				bytesArquivo = avatar.getBytes();
				arquivoBase64 = Base64Utils.encodeToString(bytesArquivo);
				System.out.println(arquivoBase64);
				InputStream inputStream = avatar.getInputStream();
				System.out.println(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// adicionar o avatar.
			Avatar avatarUsuario = new Avatar();
			avatarUsuario.setSize(size);
			avatarUsuario.setContentType(contentType);
			avatarUsuario.setArquivo(bytesArquivo);
			usuario.setAvatar(avatarUsuario);
			repository.save(usuario);
			
			
		}
	}
}