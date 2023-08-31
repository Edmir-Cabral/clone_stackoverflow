package com.fulltechjava.clonestackoverflow.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fulltechjava.clonestackoverflow.api.DTO.PerguntaDTO;
import com.fulltechjava.clonestackoverflow.api.DTO.mapper.PerguntaMapper;
import com.fulltechjava.clonestackoverflow.models.Pergunta;
import com.fulltechjava.clonestackoverflow.models.Resposta;
import com.fulltechjava.clonestackoverflow.repositories.PerguntaRepository;

@Service
public class PerguntaService {

	private PerguntaRepository perguntaRepository;
	private PerguntaMapper mapper;
	
	public PerguntaService(PerguntaRepository _perguntaRepository, PerguntaMapper mapper) {
		this.perguntaRepository = _perguntaRepository;
		this.mapper = mapper; 
	}
	
	public List<PerguntaDTO> getAllPerguntas(){
		return perguntaRepository
				.findAll()
				.stream()
				.map( pergunta -> {
					return mapper.paraDTO(pergunta);
				}).collect(Collectors.toList());
	}


	public PerguntaDTO getById(Integer id) {
		
	return perguntaRepository.findById(id)
			.map( pergunta ->{
				return mapper.paraDTO(pergunta);
			})
			.orElseThrow(() -> {
		return new ResponseStatusException(HttpStatus.NOT_FOUND, "pergunta não encontrado");
		});
	}
	
	public PerguntaDTO postPergunta(PerguntaDTO pergunta) {
		return mapper.paraDTO(perguntaRepository.save(mapper.paraEntity(pergunta)));
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