package com.fulltechjava.clonestackoverflow.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fulltechjava.clonestackoverflow.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Optional<Usuario> findByIdGoogle(String idGoogle);

}
