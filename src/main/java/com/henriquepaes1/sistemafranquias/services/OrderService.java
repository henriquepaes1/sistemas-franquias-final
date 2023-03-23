package com.henriquepaes1.sistemafranquias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquepaes1.sistemafranquias.entities.Order;
import com.henriquepaes1.sistemafranquias.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		List<Order> clientList = repository.findAll();
		
		return clientList;
	}
	
	public Order findById(Long id){
		Optional<Order> client = repository.findById(id);
		
		return client.get();
	}
	
	
	
	

}
