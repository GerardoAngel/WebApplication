package com.product;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CtrlProduct {
    
    @GetMapping("/category")
    public List<Category> getCategories(){
        List<Category> categories = Arrays.asList(
            new Category (1, "Lentes","lens"),
            new Category(2, "Sombreros", "som")
        );

        return categories;
    }
}
