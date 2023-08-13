package com.fulltechjava.clonestackoverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fulltechjava.clonestackoverflow.models.Pergunta;
import com.fulltechjava.clonestackoverflow.repositories.PerguntaRepository;

@Service
public class PerguntaService {

	private PerguntaRepository perguntaRepository;
	
	public PerguntaService(PerguntaRepository _perguntaRepository) {
		this.perguntaRepository = _perguntaRepository;
	}
	
	public List<Pergunta> getAllPerguntas(){
		return perguntaRepository.findAll();
	}

	public Pergunta postPergunta(Pergunta pergunta) {
		return perguntaRepository.save(pergunta);
	}
	
	public void delete (int id) {
		perguntaRepository.deleteById(id);
	}
	
	public Pergunta update(int id, Pergunta pergunta) {
		Pergunta entity = perguntaRepository.getReferenceById(id);
		updateData(entity, pergunta);
		return perguntaRepository.save(entity);
	}

	private void updateData(Pergunta entity, Pergunta pergunta) {
		entity.setTitulo_pergunta(pergunta.getDescricao_pergunta());
		entity.setDescricao_pergunta(pergunta.getDescricao_pergunta());
		entity.setData_pergunta(pergunta.getData_pergunta());		
	}
}
