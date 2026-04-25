package com.product.api.dto.out;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "product")
public class DtoProductOut {

    @Id
    private Integer product_id;
    private String gtin;
    private String product;
    private String description;
    private Float price;
    private Integer stock;
    private String category;   

    @Transient
    private String image;

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DtoProductOut{");
        sb.append("product_id=").append(product_id);
        sb.append(", gtin=").append(gtin);
        sb.append(", product=").append(product);
        sb.append(", description=").append(description);
        sb.append(", price=").append(price);
        sb.append(", stock=").append(stock);
        sb.append(", category=").append(category);
        sb.append(", image=").append(image);
        sb.append('}');
        return sb.toString();
    }

    
}