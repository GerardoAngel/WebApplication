package com.product.api.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;


public class DtoProductImageIn {
    
	@JsonProperty("Product_id")
	@NotNull(message="El ProductId es obligatorio")
	private Integer ProductId;


	@JsonProperty("image")
	@NotNull(message="El image es obligatorio")
	private String image;


	public Integer getProductId() {
		return ProductId;
	}


	public void setProductId(Integer ProductId) {
		this.ProductId = ProductId;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
}
