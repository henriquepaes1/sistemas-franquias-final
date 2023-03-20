package com.henriquepaes1.sistemafranquias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henriquepaes1.sistemafranquias.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
