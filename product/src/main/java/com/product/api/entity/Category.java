package com.product.api.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
    
    @Id
    private int category_id;
    private String category;
    private String tag;
    private int status;

    public Category() {
    }

    public Category(int category_id, String category, String tag) {
        this.category_id = category_id;
        this.category = category;
        this.tag = tag;
        status = 1;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getCategory() {
        return category;
    }

    public String getTag() {
        return tag;
    }   

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        if (status == 0 || status == 1) {
            this.status = status;
        } else {
            System.out.println("El estatus debe 0 or 1");
        }
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    
    @Override
    public String toString() {
        return String.format("{%d,%s,%s,%d}", category_id, category, tag, status);
    }
}