package com.henriquepaes1.sistemafranquias.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriquepaes1.sistemafranquias.entities.Client;
import com.henriquepaes1.sistemafranquias.services.ClientService;

@RestController
@RequestMapping(value="/clients")
public class ClientResource {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		
		List<Client> clientList = clientService.findAll();
		
		return ResponseEntity.ok().body(clientList);
	}

}
