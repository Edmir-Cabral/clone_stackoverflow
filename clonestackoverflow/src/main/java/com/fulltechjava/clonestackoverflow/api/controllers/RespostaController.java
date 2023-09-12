package com.fulltechjava.clonestackoverflow.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fulltechjava.clonestackoverflow.api.DTO.RespostaDTO;
import com.fulltechjava.clonestackoverflow.models.Resposta;
import com.fulltechjava.clonestackoverflow.services.RespostaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RespostaController {

	private RespostaService _service;
	
	public RespostaController(RespostaService service) {
		 _service = service;
	}
	
	@PostMapping("/respostas")
	public RespostaDTO criar(@RequestBody RespostaDTO resposta) {
		return _service.inserir(resposta);
	}
	
	
	@GetMapping("/respostas")
	public List<RespostaDTO> listar() {
		return _service.buscarTodas();
	}
	
	@GetMapping("/respostas/{id}")
	public RespostaDTO buscarPorId(@PathVariable Integer id) {
		return _service.buscarPorId(id);
	}
	
	@PutMapping("/respostas/{id}")
	public void atualizar(@PathVariable Integer id, @RequestBody Resposta resposta) {
		_service.atualizar(id, resposta); 
	}
	
//	@DeleteMapping("respostas/{id}")
//	public void deletar(@PathVariable Integer id) {
//		_service.deletar(id);
//	}
}
