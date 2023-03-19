package com.henriquepaes1.sistemafranquias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henriquepaes1.sistemafranquias.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
