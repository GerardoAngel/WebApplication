package com.product.api.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.entity.Category;


@RestController
public class CtrlCategory{
    
    @GetMapping("/category")
    public List<Category> getCategories(){
        List<Category> categories = Arrays.asList(
            new Category (1, "Lentes","lens"),
            new Category(2, "Sombreros", "som")
        ); 
        return categories;
    }
}
