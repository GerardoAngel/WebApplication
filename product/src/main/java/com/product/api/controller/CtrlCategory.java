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

import com.product.api.dto.in.DtoCategoryIn;
import com.product.api.entity.Category;
import com.product.api.service.SvcCategory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
@Tag(name = "Category", description = "Categorías de los productos")
public class CtrlCategory {
    @Autowired
    SvcCategory svc;

    @GetMapping
    @Operation(summary = "Consultar categorías", description = "Lista las categorías registradas en el sistema")
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(svc.findAll());
    }

    @GetMapping("/active")
    @Operation(summary = "Consultar categorías activas", description = "Lista las categorías activas registradas en el sistema")
    public ResponseEntity<List<Category>> findActive() {
        return ResponseEntity.ok(svc.findActive());
    }

    @PostMapping
    @Operation(summary = "Crear categoría", description = "Crea una nueva categoría en el sistema")
    public ResponseEntity<Void> create(@Valid @RequestBody DtoCategoryIn in) {
    	svc.create(in);
    	return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar categoría", description= "Actualiza los datos de una categoría existente en el sistema")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id, @Valid @RequestBody DtoCategoryIn in) {
    	svc.update(in, id);
    	return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/enable")
    @Operation(summary = "Habilitar categoría", description = "Habilita una categoría existente en el sistema")
    public ResponseEntity<Void> enable(@PathVariable Integer id) {
    	svc.enable(id);
    	return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/disable")
    @Operation(summary = "Deshabilitar categoría", description = "Deshabilita una categoría existente en el sistema")
    public ResponseEntity<Void> disable(@PathVariable Integer id) {
    	svc.disable(id);
    	return ResponseEntity.ok().build();
    }
}
