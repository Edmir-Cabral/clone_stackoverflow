package com.fulltechjava.clonestackoverflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fulltechjava.clonestackoverflow.models.Pergunta;
import com.fulltechjava.clonestackoverflow.models.Resposta;
import com.fulltechjava.clonestackoverflow.models.Usuario;
import com.fulltechjava.clonestackoverflow.repositories.UsuarioRepository;

@Configuration
public class LoadDatabase {

	 private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	  @Bean
	  CommandLineRunner initDatabase(UsuarioRepository repository) {

	    return args -> {
	    	Pergunta pergunta1 = new Pergunta("fazendo pergunta");
	    	Resposta resposta = new Resposta("respondendo pergunta");
	    	
	    	List<Resposta> respostas = new ArrayList<Resposta>();
	    	List<Pergunta> perguntas = new ArrayList<Pergunta>();
	    	respostas.add(resposta);
	    	perguntas.add(pergunta1);
	    	
	    	
	      log.info("Preloading " + repository.save(new Usuario(1, 
	    		  "celso@gmail.com",
	    		  "celso",
	    		  perguntas,
	    		  respostas
	    		  )));
	      
	      log.info("listando dados \n" + repository.findAll());
	    };
	  }
}
