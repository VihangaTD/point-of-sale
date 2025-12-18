package com.springbootacademy.point_of_sales.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/test")
public class TestController {

    @GetMapping
    public String getMyText(){
        String myText = "This is my first springboot app";
        System.out.println(myText);
        return myText;
    }

}
