package com.henriquepaes1.sistemafranquias.config;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.henriquepaes1.sistemafranquias.entities.Client;
import com.henriquepaes1.sistemafranquias.entities.Order;
import com.henriquepaes1.sistemafranquias.repositories.ClientRepository;
import com.henriquepaes1.sistemafranquias.repositories.OrderRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		Client client1 = new Client(null, "Henrique Paes", LocalDate.parse("2003-06-12"), 
				"henriquee.paes@gmail.com", "(11)98298-8799", "aaabbbbccccc");
		
		Client client2 = new Client(null, "Giovanna Bulgarelli", LocalDate.parse("2002-04-18"),
				"bulga.adv@gmail.com", "(11)96595-9008", "eeessssaaa");
		
		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), client1);
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), client2);
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), client1); 
		
		clientRepository.saveAll(Arrays.asList(client1, client2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
		
	}

}
