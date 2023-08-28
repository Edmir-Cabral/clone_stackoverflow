package com.fulltechjava.clonestackoverflow.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.fulltechjava.clonestackoverflow.models.Usuario;
import com.fulltechjava.clonestackoverflow.repositories.UsuarioRepository;
import com.fulltechjava.clonestackoverflow.services.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
    private UsuarioService usuarioService;

    @PostMapping("/logar")
    public ResponseEntity<String> salvarUsuario(@RequestBody Usuario usuario) {
        try {
            return usuarioService.autenticarOuCriarUsuario(usuario);
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar o pedido.");
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
