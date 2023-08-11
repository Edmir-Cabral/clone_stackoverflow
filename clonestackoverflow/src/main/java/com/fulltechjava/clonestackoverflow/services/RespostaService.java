package com.fulltechjava.clonestackoverflow.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fulltechjava.clonestackoverflow.models.Resposta;
import com.fulltechjava.clonestackoverflow.repositories.RespostaRepository;

@Service
public class RespostaService {

	private RespostaRepository _repository;

	public RespostaService(RespostaRepository repository) {
		_repository = repository;
	}

	public List<Resposta> getAll() {
		return _repository.findAll();
	}

	public Resposta getById(Integer id) {
		return _repository.findById(id).orElseThrow(() -> {
			return new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
		});
	}

	public void update(Integer id, Resposta resposta) {
		_repository.findById(id).map(respostaDb -> {
			resposta.setId(respostaDb.getId());
			_repository.save(resposta);
			return respostaDb;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Falha ao alterar resposta"));
	}

	public Resposta Save(Resposta resposta) {
		return _repository.save(resposta);
	}

	public void delete(Integer id) {
		Resposta respostaId = getById(id);
		_repository.delete(respostaId);
	}

}
