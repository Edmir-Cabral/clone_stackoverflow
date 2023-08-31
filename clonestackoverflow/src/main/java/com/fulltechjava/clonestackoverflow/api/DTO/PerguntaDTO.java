package com.fulltechjava.clonestackoverflow.api.DTO;

import java.sql.Date;
import java.util.List;

import com.fulltechjava.clonestackoverflow.models.Resposta;
import com.fulltechjava.clonestackoverflow.models.Usuario;

import lombok.Data;

@Data
public record PerguntaDTO( 
		Integer id,
		String titulo_pergunta,
		String descricao_pergunta,
		Date data_pergunta,
		Usuario usuario,
		List<Resposta> respostas)
{}
