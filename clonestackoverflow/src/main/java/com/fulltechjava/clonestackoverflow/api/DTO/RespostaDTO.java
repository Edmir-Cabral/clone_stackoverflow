package com.fulltechjava.clonestackoverflow.api.DTO;

import java.sql.Date;

import com.fulltechjava.clonestackoverflow.models.Pergunta;
import com.fulltechjava.clonestackoverflow.models.Usuario;

//{
//    "id": 1,
//    "descricao_resposta": "NEW teste2 AMEM 1",
//    "data_resposta": "2023-08-10",
//    "usuario": {
//        "id": 1,
//        "idGoogle": "102507315602561775911",
//        "email": "vdmcelso@gmail.com",
//        "nome": "Celso Delfino",
//        "data_criacao": "2023-08-11T13:45:15.000+00:00"
//    },
//    "pergunta": {
//        "id": 1,
//        "titulo_pergunta": "titulo 1",
//        "descricao_pergunta": "descricao 1",
//        "data_pergunta": "2023-08-11",
//        "usuario": {
//            "id": 1,
//            "idGoogle": "102507315602561775911",
//            "email": "vdmcelso@gmail.com",
//            "nome": "Celso Delfino",
//            "data_criacao": "2023-08-11T13:45:15.000+00:00"
//        }
//    }
//},

public record RespostaDTO(
		Integer id, 
		String descricao_resposta, 
		Date data_resposta, 
		Usuario usuario,
		Pergunta pergunta) {
}
