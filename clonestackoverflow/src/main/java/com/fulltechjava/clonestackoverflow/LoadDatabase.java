package com.fulltechjava.clonestackoverflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fulltechjava.clonestackoverflow.repositories.RespostaRepository;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(RespostaRepository repository) {
		return args -> {				
			
			log.info("Aplicação funcionando");
			log.info("select no banco:" + repository.findAll());
		};
	}
}
