package com.Rishikesh.SpringSecurity.Service;

import com.Rishikesh.SpringSecurity.DAO.UserRepo;
import com.Rishikesh.SpringSecurity.Model.User;
import com.Rishikesh.SpringSecurity.Model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user =repo.findByUsername(username);
        if(user==null){
            System.out.println("user 404");
            throw new UsernameNotFoundException("User 404");
        }

        return new UserPrincipal(user);
    }
}
