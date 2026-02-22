package com.product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/helloworld")
public class CtrlProduct {
    
    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }
}
