package com.Rishikesh.SpringSecurity.Service;

import com.Rishikesh.SpringSecurity.DAO.UserRepo;
import com.Rishikesh.SpringSecurity.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

   @Autowired
  private UserRepo repo;
   private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public User saveUser(User user){
        user.setPassword(encoder.encode((user.getPassword())));
        System.out.println(user.getPassword());
        return repo.save(user);
    }
}
