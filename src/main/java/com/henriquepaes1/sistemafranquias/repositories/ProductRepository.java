package com.henriquepaes1.sistemafranquias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henriquepaes1.sistemafranquias.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
