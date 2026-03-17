package com.product.api.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.entity.Category;
import com.product.api.service.SvcCategory;
import com.product.api.dto.ApiResponse;
import com.product.api.dto.DtoCategoryIn;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CtrlCategory {
    @Autowired
    SvcCategory svc;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(svc.findAll());
    }

    @GetMapping("/active")
    public ResponseEntity<List<Category>> findActive() {
        return ResponseEntity.ok(svc.findActive());
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody DtoCategoryIn in) {
    	svc.create(in);
    	return ResponseEntity.ok(new ApiResponse("La categoría ha sido registrada"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable("id") Integer id, @Valid @RequestBody DtoCategoryIn in) {
    	svc.update(in, id);
    	return ResponseEntity.ok(new ApiResponse("La categoría ha sido actualizada"));
    }

    @PatchMapping("/{id}/enable")
    public ResponseEntity<ApiResponse> enable(@PathVariable Integer id) {
    	svc.enable(id);
    	return ResponseEntity.ok(new ApiResponse("La categoría ha sido activada"));
    }

    @PatchMapping("/{id}/disable")
    public ResponseEntity<ApiResponse> disable(@PathVariable Integer id) {
    	svc.disable(id);
    	return ResponseEntity.ok(new ApiResponse("La categoría ha sido desactivada"));
    }
}
