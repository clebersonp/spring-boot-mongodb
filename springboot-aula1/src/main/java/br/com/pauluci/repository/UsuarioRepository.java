package br.com.pauluci.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.pauluci.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}