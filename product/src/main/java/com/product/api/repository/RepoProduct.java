package com.product.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.api.entity.Product;
import com.product.api.entity.ProductImage;

@Repository
public interface RepoProduct extends JpaRepository<Product, Integer> {
	ProductImage findByProductId(Integer product_id);
}
