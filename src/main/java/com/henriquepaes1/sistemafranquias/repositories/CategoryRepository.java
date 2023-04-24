package com.henriquepaes1.sistemafranquias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henriquepaes1.sistemafranquias.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
