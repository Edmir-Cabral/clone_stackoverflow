package com.fulltechjava.clonestackoverflow.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fulltechjava.clonestackoverflow.models.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Integer>{
	
	List<Pergunta>findBytituloPerguntaContaining(String titulo);
}