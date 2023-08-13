package com.fulltechjava.clonestackoverflow.api.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fulltechjava.clonestackoverflow.models.Pergunta;
import com.fulltechjava.clonestackoverflow.services.PerguntaService;

@RestController
@RequestMapping("/pergunta")
public class PerguntaController {

	@Autowired
	private PerguntaService perguntaService;

	public PerguntaController(PerguntaService _perguntaService) {
		this.perguntaService = _perguntaService;
	}

	@GetMapping("/")
	public List<Pergunta> getPerguntas() {
		return perguntaService.getAllPerguntas();
	}

	@PostMapping("/")
	public ResponseEntity<Pergunta> postPergunta(@RequestBody Pergunta pergunta) {
		pergunta = perguntaService.postPergunta(pergunta);
		URI uri = ServletUriComponentsBuilder.
		fromCurrentRequest().
		path("/{id}").
		buildAndExpand(pergunta.getId()).toUri();
		return ResponseEntity.created(uri).body(pergunta);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id){
		perguntaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Pergunta> update(@PathVariable int id, @RequestBody Pergunta pergunta){
		 pergunta = perguntaService.update(id, pergunta);
		 return ResponseEntity.ok().body(pergunta);
	}
}
