package com.fulltechjava.clonestackoverflow.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fulltechjava.clonestackoverflow.api.DTO.RespostaDTO;
import com.fulltechjava.clonestackoverflow.api.DTO.mapper.RespostaMapper;
import com.fulltechjava.clonestackoverflow.models.Resposta;
import com.fulltechjava.clonestackoverflow.repositories.RespostaRepository;

@Service
public class RespostaService {

	private RespostaRepository _repository;
	private RespostaMapper _mapper;

	public RespostaService(RespostaRepository repository, RespostaMapper mapper) {
		_repository = repository;
		_mapper = mapper;
	}

	public List<RespostaDTO> buscarTodas() {		
		return _repository.findAll()
				.stream()
				.map( resposta ->{
					return _mapper.paraDTO(resposta);
				}).collect(Collectors.toList());
	}

	public RespostaDTO buscarPorId(Integer id) {
		return _repository.findById(id)
				.map( resposta ->{
					return _mapper.paraDTO(resposta);
				}).
				orElseThrow(() -> {
			return new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
		});
	}

	public void atualizar(Integer id, Resposta resposta) {
		_repository.findById(id).map(respostaDb -> {
			resposta.setId(respostaDb.getId());
			_mapper.paraDTO(_repository.save(resposta));
			return respostaDb;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Falha ao alterar resposta"));
	}

	public RespostaDTO inserir(RespostaDTO resposta) {
		return _mapper.paraDTO(_repository.save(_mapper.paraEntity(resposta)));
	}

//	public void deletar(Integer id) {
//		Resposta respostaId = getById(id);
//		_repository.delete(respostaId);
//}

}
