package com.fulltechjava.clonestackoverflow.controllers;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {
	
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fulltechjava.clonestackoverflow.models.Usuario;
import com.fulltechjava.clonestackoverflow.repositories.UsuarioRepository;

@Controller
public class UsuarioController {
	//TODO: RAFAELPINO - AINDA FALTA EU IMPLEMENTAR
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/listar")
	public ModelAndView listarTodos() {
		try {
			List<Usuario> usuario = usuarioRepository.findAll();
			return new ModelAndView("usuario/listar", "listar_usuarios", usuario);
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
	}
>>>>>>> 490f7aaea73e83ae4d642fcbaf984d5740a5d940
}
