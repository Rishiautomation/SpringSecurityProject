package com.Rishikesh.SpringSecurity.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String greet(HttpServletRequest request){
        return "Hello World "+ request.getSession().getId();
    }
    @GetMapping("About")
    public String about(HttpServletRequest request){
        return "Rishkesh " + request.getSession().getId();
    }

}
