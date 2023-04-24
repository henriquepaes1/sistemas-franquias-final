package com.henriquepaes1.sistemafranquias.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id){
		
		Client client = clientService.findById(id);
		return ResponseEntity.ok().body(client);	
	}
	
	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody Client client){
		Client insertedClient = clientService.insert(client);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(insertedClient.getId()).toUri();
		
		return ResponseEntity.created(uri).body(insertedClient);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		clientService.delete(id);	
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client){
		Client updatedClient = clientService.update(id, client);	
		return ResponseEntity.ok().body(updatedClient);
	}

}
