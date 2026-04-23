package com.product.api.service;

import com.product.api.dto.in.DtoProductImageIn;
import com.product.api.entity.ProductImage;

public interface SvcProductImage {
    public ProductImage getProductImages(Integer productId);
    public String upload(Integer productId, DtoProductImageIn in);
    public String deleteProductImage(Integer productImageId);
}