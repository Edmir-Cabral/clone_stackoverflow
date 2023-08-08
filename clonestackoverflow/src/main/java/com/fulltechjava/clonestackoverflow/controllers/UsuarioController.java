package com.fulltechjava.clonestackoverflow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fulltechjava.clonestackoverflow.models.Usuario;
import com.fulltechjava.clonestackoverflow.repositories.UsuarioRepository;

@Controller
public class UsuarioController {
	// TODO: RAFAELPINO - AINDA FALTA EU IMPLEMENTAR
	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("/logar")
	public ResponseEntity<String> salvarUsuario(@RequestBody Usuario usuario) {

		String idGoogle = usuario.getIdGoogle();
		
		Optional<Usuario> usuarioExistente = usuarioRepository.findByIdGoogle(idGoogle);

		if (usuarioExistente.isPresent()) {
			return ResponseEntity.ok("Usuário autenticado com sucesso!");

		} else {
			Usuario novoUsuario = new Usuario();
			novoUsuario.setEmail(usuario.getEmail());
			novoUsuario.setNome(usuario.getNome());
			novoUsuario.setIdGoogle(usuario.getIdGoogle());
			novoUsuario.setData_criacao(new Date());

			usuarioRepository.save(novoUsuario);

			return ResponseEntity.ok("Usuário salvo com sucesso!");
		}
	}

	@GetMapping("/listar")
	public ModelAndView listarTodos() {
		try {
			List<Usuario> usuario = usuarioRepository.findAll();
			return new ModelAndView("usuario/listar", "listar_usuarios", usuario);
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
	}
}
