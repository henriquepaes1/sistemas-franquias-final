package com.henriquepaes1.sistemafranquias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquepaes1.sistemafranquias.entities.Category;
import com.henriquepaes1.sistemafranquias.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		List<Category> clientList = repository.findAll();
		
		return clientList;
	}
	
	public Category findById(Long id){
		Optional<Category> client = repository.findById(id);
		
		return client.get();
	}
	
	
	
	

}
