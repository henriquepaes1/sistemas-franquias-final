package com.henriquepaes1.sistemafranquias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquepaes1.sistemafranquias.entities.Product;
import com.henriquepaes1.sistemafranquias.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		List<Product> clientList = repository.findAll();
		
		return clientList;
	}
	
	public Product findById(Long id){
		Optional<Product> client = repository.findById(id);
		
		return client.get();
	}
	

}
