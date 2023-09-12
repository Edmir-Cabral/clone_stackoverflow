package com.fulltechjava.clonestackoverflow.api.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fulltechjava.clonestackoverflow.api.DTO.PerguntaDTO;
import com.fulltechjava.clonestackoverflow.models.Pergunta;
import com.fulltechjava.clonestackoverflow.services.PerguntaService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class PerguntaController {

	@Autowired
	private PerguntaService perguntaService;

	public PerguntaController(PerguntaService _perguntaService) {
		this.perguntaService = _perguntaService;
	}

	@GetMapping("/perguntas")
	public List<PerguntaDTO> listar() {
		return perguntaService.buscarTodas();
	}
	
	@GetMapping("/perguntas/titulo")
	public List<Pergunta> buscarPorTitulo(@RequestParam("tituloPergunta") String tituloPergunta){
		return perguntaService.buscarPorTitulo(tituloPergunta);
	}
	
	@GetMapping("/perguntas/{id}")
	public PerguntaDTO buscarPorId(@PathVariable Integer id) {
		return perguntaService.buscarPorId(id);
	}
		
	@PostMapping("/perguntas")
	public PerguntaDTO criar(@RequestBody PerguntaDTO pergunta) {
		return perguntaService.inserir(pergunta);
	}
	
	@DeleteMapping(value = "/perguntas/{id}")
	public ResponseEntity<Void> deletar(@PathVariable int id){
		perguntaService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/perguntas/{id}")
	public ResponseEntity<Pergunta> atualizar(@PathVariable int id, @RequestBody Pergunta pergunta){
		 pergunta = perguntaService.atualizar(id, pergunta);
		 return ResponseEntity.ok().body(pergunta);
	}
}
