package com.Rishikesh.SpringSecurity.Controller;

import com.Rishikesh.SpringSecurity.Model.User;
import com.Rishikesh.SpringSecurity.Service.JWTService;
import com.Rishikesh.SpringSecurity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
 @Autowired
private UserService service;

 @Autowired
    AuthenticationManager authenticationManager;
 @Autowired
 private JWTService jwtService;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service.saveUser(user);

    }

    //Now we will create for a token creation for login
    @PostMapping("/login")
    public String login(@RequestBody User user){
 Authentication authentication =authenticationManager
         .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

         if(authentication.isAuthenticated()){
             return jwtService.generateToken(user.getUsername()); //yeh token return karega
         }
         else {
             return "Failure";
         }
    }


}
