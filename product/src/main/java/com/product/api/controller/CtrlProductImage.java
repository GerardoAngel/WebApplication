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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
@Tag(name = "ProductImage", description = "Carga imagenes de los productos")
public class CtrlProductImage {

    @Autowired
    SvcProductImage svc;

    @GetMapping("/{id}/image")
    @Operation(summary = "Consultar imágenes de producto", description = "Lista las imágenes de un producto registrado en el sistema")
    public ResponseEntity<ProductImage> getProductImages(@PathVariable Integer id) {
        return ResponseEntity.ok(svc.getProductImages(id));
    }

    @PostMapping("/{id}/image")
    @Operation(summary = "Crear imagen de producto", description = "Crea una nueva imagen para un producto existente en el sistema")
    public ResponseEntity<String> createProductImage(
            @PathVariable Integer id,
            @Valid @RequestBody DtoProductImageIn in) {
        return ResponseEntity.ok(svc.upload(id, in));
    }

    @DeleteMapping("/{id}/image/{product-image-id}")
    @Operation(summary = "Eliminar imagen de producto", description = "Elimina una imagen de un producto existente en el sistema")
    public ResponseEntity<String> deleteProductImage(
            @PathVariable("product-image-id") Integer productImageId) {
        return ResponseEntity.ok(svc.deleteProductImage(productImageId));
    }
}