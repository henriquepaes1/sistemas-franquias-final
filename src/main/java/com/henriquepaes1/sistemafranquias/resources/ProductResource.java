package com.henriquepaes1.sistemafranquias.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriquepaes1.sistemafranquias.entities.Product;
import com.henriquepaes1.sistemafranquias.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource {
	
	@Autowired
	ProductService clientService;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		
		List<Product> clientList = clientService.findAll();
		return ResponseEntity.ok().body(clientList);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		
		Product client = clientService.findById(id);
		return ResponseEntity.ok().body(client);	
	}

}
