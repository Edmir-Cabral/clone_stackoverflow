package com.fulltechjava.clonestackoverflow.api.DTO.mapper;

import org.springframework.stereotype.Component;

import com.fulltechjava.clonestackoverflow.api.DTO.RespostaDTO;
import com.fulltechjava.clonestackoverflow.models.Resposta;

//{
//    "descricao_resposta": "TESTE DTO",
//    "data_resposta": "2023-08-10",
//    "usuario": {
//        "id": 1
//    },
//    "pergunta": {
//        "id": 1,
//        "usuario": {
//            "id": 1
//        }
//    }
//}

@Component
public class RespostaMapper {

	public RespostaDTO paraDTO(Resposta resposta) {
		return new RespostaDTO(resposta.getId(), 
				resposta.getDescricao_resposta(), resposta.getData_resposta(),
				resposta.getUsuario(), resposta.getPergunta());
	}
	
	
	public Resposta paraEntity(RespostaDTO dto) {
		Resposta resposta = new Resposta();
		
		resposta.setDescricao_resposta(dto.descricao_resposta());
		resposta.setData_resposta(dto.data_resposta());
		resposta.setUsuario(dto.usuario());
		resposta.setPergunta(dto.pergunta());
		return resposta;
		
	}
	
	
}
