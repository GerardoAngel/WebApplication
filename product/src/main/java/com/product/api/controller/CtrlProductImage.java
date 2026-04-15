package com.product.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.dto.in.DtoProductImageIn;
import com.product.api.service.SvcProductImage;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Product-image")
public class CtrlProductImage {
	
    @Autowired
    SvcProductImage svc;
	
    @PostMapping
   public ResponseEntity<Void> createProductImage(@Valid @RequestBody DtoProductImageIn in){
   	svc.upload(in);
		return ResponseEntity.ok().build();
    }
}