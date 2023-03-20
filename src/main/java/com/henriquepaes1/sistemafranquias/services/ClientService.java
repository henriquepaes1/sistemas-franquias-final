package com.henriquepaes1.sistemafranquias.services;

import java.util.List;

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
	
	
	
	

}
