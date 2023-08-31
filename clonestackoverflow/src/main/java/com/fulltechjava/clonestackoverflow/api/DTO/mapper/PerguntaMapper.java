package com.fulltechjava.clonestackoverflow.api.DTO.mapper;

import org.springframework.stereotype.Component;

import com.fulltechjava.clonestackoverflow.api.DTO.PerguntaDTO;
import com.fulltechjava.clonestackoverflow.api.DTO.RespostaDTO;
import com.fulltechjava.clonestackoverflow.models.Pergunta;
import com.fulltechjava.clonestackoverflow.models.Resposta;

@Component
public class PerguntaMapper {
	
	public PerguntaDTO paraDTO(Pergunta pergunta) {
		return new PerguntaDTO(pergunta.getId(), 
				pergunta.getTitulo_pergunta(),
				pergunta.getDescricao_pergunta(),
				pergunta.getData_pergunta(),
				pergunta.getUsuario(),
				pergunta.getRespostas());
	}
	
	
	public Pergunta paraEntity(PerguntaDTO dto) {
		Pergunta pergunta = new Pergunta();
		
		pergunta.setDescricao_pergunta(dto.descricao_pergunta());
		pergunta.setData_pergunta(dto.data_pergunta());
		pergunta.setUsuario(dto.usuario());
		pergunta.setTitulo_pergunta(dto.titulo_pergunta());
		return pergunta;
		
	}

}