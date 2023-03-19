package com.henriquepaes1.sistemafranquias.resources;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriquepaes1.sistemafranquias.entities.Client;

@RestController
@RequestMapping(value="/users")
public class ClientResource {
	
	@GetMapping
	public List<Client> findAll(){
		
		return null;
	}

}
