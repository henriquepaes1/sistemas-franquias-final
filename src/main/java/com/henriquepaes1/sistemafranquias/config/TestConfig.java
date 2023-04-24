package com.henriquepaes1.sistemafranquias.config;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.henriquepaes1.sistemafranquias.entities.Category;
import com.henriquepaes1.sistemafranquias.entities.Client;
import com.henriquepaes1.sistemafranquias.entities.Order;
import com.henriquepaes1.sistemafranquias.entities.OrderItem;
import com.henriquepaes1.sistemafranquias.entities.Payment;
import com.henriquepaes1.sistemafranquias.entities.Product;
import com.henriquepaes1.sistemafranquias.entities.enums.OrderStatus;
import com.henriquepaes1.sistemafranquias.repositories.CategoryRepository;
import com.henriquepaes1.sistemafranquias.repositories.ClientRepository;
import com.henriquepaes1.sistemafranquias.repositories.OrderItemRepository;
import com.henriquepaes1.sistemafranquias.repositories.OrderRepository;
import com.henriquepaes1.sistemafranquias.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		Client client1 = new Client(null, "Henrique Paes", LocalDate.parse("2003-06-12"), 
				"henriquee.paes@gmail.com", "(11)98298-8799", "aaabbbbccccc");
		
		Client client2 = new Client(null, "Giovanna Bulgarelli", LocalDate.parse("2002-04-18"),
				"bulga.adv@gmail.com", "(11)96595-9008", "eeessssaaa");
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		
		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED, client1);
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, client2);
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED,client1); 
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
	
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		clientRepository.saveAll(Arrays.asList(client1, client2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		OrderItem oi1 = new OrderItem(order1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(order1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(order2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(order3, p5, 2, p5.getPrice()); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		p1.getCategory().add(cat2);
		p2.getCategory().add(cat1);
		p2.getCategory().add(cat3);
		p3.getCategory().add(cat3);
		p4.getCategory().add(cat3);
		p5.getCategory().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), order1);
		
		order1.setPayment(pay1);
		
		orderRepository.save(order1);
		
	}

}
