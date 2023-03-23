package com.henriquepaes1.sistemafranquias.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriquepaes1.sistemafranquias.entities.Order;
import com.henriquepaes1.sistemafranquias.services.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderResource {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		
		List<Order> OrderList = orderService.findAll();
		return ResponseEntity.ok().body(OrderList);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		
		Order order = orderService.findById(id);
		return ResponseEntity.ok().body(order);	
	}

}
