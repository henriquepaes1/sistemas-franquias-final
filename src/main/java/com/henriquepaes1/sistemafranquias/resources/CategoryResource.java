package com.henriquepaes1.sistemafranquias.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriquepaes1.sistemafranquias.entities.Category;
import com.henriquepaes1.sistemafranquias.services.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@Autowired
	CategoryService clientService;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		
		List<Category> clientList = clientService.findAll();
		return ResponseEntity.ok().body(clientList);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		
		Category client = clientService.findById(id);
		return ResponseEntity.ok().body(client);	
	}

}
