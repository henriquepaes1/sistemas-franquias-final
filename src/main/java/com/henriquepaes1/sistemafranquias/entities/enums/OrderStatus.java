package com.henriquepaes1.sistemafranquias.entities.enums;

public enum OrderStatus {
	WAITING_PAYMENT(1),
	PAID(2),
	PACKAGING(3),
	SHIPPED(4),
	DELIVERED(5),
	CANCELED(6);
	
	private Integer code;

	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	/* Este método recebe como parâmetro um inteiro,
	e retorna o OrderStatus correspondente */
	
	public static OrderStatus correspondingStatus(int code) {
		for(OrderStatus corresponding: OrderStatus.values()) {
			if(corresponding.getCode() == code) {
				return corresponding;
			}
		}
		
		throw new IllegalArgumentException("Invalid OrderStatus code");
		
	}
	
	
}
