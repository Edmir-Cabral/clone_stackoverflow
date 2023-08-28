package com.fulltechjava.clonestackoverflow.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fulltechjava.clonestackoverflow.models.Usuario;
import com.fulltechjava.clonestackoverflow.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
    private JwtTokenUtil jwtTokenUtil;

	public ResponseEntity<String> autenticarOuCriarUsuario(Usuario usuario) {
		
		String idGoogle = usuario.getIdGoogle();
		String userName = usuario.getNome();

		Optional<Usuario> usuarioExistente = usuarioRepository.findByIdGoogle(idGoogle);

		if (usuarioExistente.isPresent()) {
		    String token = jwtTokenUtil.generateToken(usuarioExistente.get().getIdGoogle(), userName);
		    return ResponseEntity.ok("{\"token\": \"" + token + "\"}");
		} else {
		    Usuario novoUsuario = criarNovoUsuario(usuario);
		    String token = jwtTokenUtil.generateToken(novoUsuario.getIdGoogle(), userName);
		    return ResponseEntity.status(HttpStatus.CREATED).body("{\"token\": \"" + token + "\"}");
		}
	}

	private Usuario criarNovoUsuario(Usuario usuario) {
		Usuario novoUsuario = new Usuario();
		novoUsuario.setEmail(usuario.getEmail());
		novoUsuario.setNome(usuario.getNome());
		novoUsuario.setIdGoogle(usuario.getIdGoogle());
		novoUsuario.setData_criacao(new Date());

		return usuarioRepository.save(novoUsuario);
	}
	
}
