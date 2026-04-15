package com.product.api.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DtoProductOut {

	@Id
	private Integer customer_id;
	
	private String name;
	
	private String surname;
	
	private String rfc;
	
	private String mail;
	
	private String phone_number;
	
	private String address;
	
	private String region;
	
	private String image;


}
