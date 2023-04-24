package com.henriquepaes1.sistemafranquias.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.henriquepaes1.sistemafranquias.entities.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	
	/* Internamente, o tipo será tratado pelo seu número correspondente,
	porém ainda será um orderStatus externamente */
	private Integer orderStatus;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@OneToMany(mappedBy="id.order")
	private Set<OrderItem> items = new HashSet<>();	
	
	@OneToOne(mappedBy="order", cascade=CascadeType.ALL)
	private Payment payment;
	
	public Order() {
	}
	
	public Order(Long id, Instant moment, OrderStatus orderStatus, Client client) {
		super();
		this.id = id;
		this.setOrderStatus(orderStatus);
		this.moment = moment;
		this.client = client;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	public Client getClient() {
		return client;
	}
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.correspondingStatus(this.orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
	}
	
	public Set<OrderItem> getItems(){
		return items;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public double getTotal() {
		double soma = 0.0;
		for(OrderItem oi: items) {
			soma += oi.getSubTotal();
		}
		return soma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, moment);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id) && Objects.equals(moment, other.moment);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", moment=" + moment + "]";
	}

}
