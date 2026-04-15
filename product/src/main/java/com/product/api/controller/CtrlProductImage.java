package com.product.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.dto.in.DtoProductImageIn;
import com.product.api.entity.ProductImage;
import com.product.api.service.SvcProductImage;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class CtrlProductImage {

    @Autowired
    SvcProductImage svc;

    @GetMapping("/{id}/image")
    public ResponseEntity<ProductImage> getProductImages(@PathVariable Integer id) {
        return ResponseEntity.ok(svc.getProductImages(id));
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<String> createProductImage(
            @PathVariable Integer id,
            @Valid @RequestBody DtoProductImageIn in) {
        return ResponseEntity.ok(svc.upload(id, in));
    }

    @DeleteMapping("/{id}/image/{product-image-id}")
    public ResponseEntity<String> deleteProductImage(
            @PathVariable("product-image-id") Integer productImageId) {
        return ResponseEntity.ok(svc.deleteProductImage(productImageId));
    }
}