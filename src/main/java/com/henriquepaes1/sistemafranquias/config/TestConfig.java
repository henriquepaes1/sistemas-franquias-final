package com.henriquepaes1.sistemafranquias.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.henriquepaes1.sistemafranquias.entities.Client;
import com.henriquepaes1.sistemafranquias.repositories.ClientRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void run(String... args) throws Exception {
		Client client1 = new Client(null, "Henrique Paes", LocalDate.parse("2003-06-12"), 
				"henriquee.paes@gmail.com", "(11)98298-8799", "aaabbbbccccc");
		
		Client client2 = new Client(null, "Giovanna Bulgarelli", LocalDate.parse("2002-04-18"),
				"bulga.adv@gmail.com", "(11)96595-9008", "eeessssaaa");
		
		clientRepository.saveAll(Arrays.asList(client1, client2));
		
	}

}
