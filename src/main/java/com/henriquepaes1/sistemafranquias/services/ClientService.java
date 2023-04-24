package com.henriquepaes1.sistemafranquias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquepaes1.sistemafranquias.entities.Client;
import com.henriquepaes1.sistemafranquias.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll(){
		List<Client> clientList = repository.findAll();
		
		return clientList;
	}
	
	public Client findById(Long id){
		Optional<Client> client = repository.findById(id);
		
		return client.get();
	}
	
	public Client insert(Client client) {
		return repository.save(client);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Client update(Long id, Client client) {
		Client entity = repository.getReferenceById(id);
		updateData(entity, client);
		return repository.save(entity);
	}
	
	public void updateData(Client entity, Client obj) {
		entity.setName(obj.getName());
		entity.setBirthDate(obj.getBirthDate());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
	
	
	

}
