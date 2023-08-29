package com.fulltechjava.clonestackoverflow.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class RespostaController {

	@Autowired
	private RespostaService _service;
	
	public RespostaController(RespostaService service) {
		 _service = service;
	}
	
	@PostMapping("/respostas")
	public RespostaDTO post(@RequestBody RespostaDTO resposta) {
		return _service.Save(resposta);
	}
	
	
	@GetMapping("/respostas")
	public List<RespostaDTO> getAll() {
		return _service.getAll();
	}
	
	@GetMapping("/respostas/{id}")
	public RespostaDTO getById(@PathVariable Integer id) {
		return _service.getById(id);
	}
	
	@PutMapping("/respostas/{id}")
	public void update(@PathVariable Integer id, @RequestBody Resposta resposta) {
		_service.update(id, resposta); 
	}
	
//	@DeleteMapping("respostas/{id}")
//	public void delete(@PathVariable Integer id) {
//		_service.delete(id);
//	}
}
