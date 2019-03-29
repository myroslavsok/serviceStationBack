package com.example.demo.security.services;

import com.example.demo.security.domains.UserAdmin;
import com.example.demo.security.repositories.UserAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserAdminDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserAdminRepository userAdminRepository;

    public UserAdminDetailsServiceImpl() {}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAdmin applicationUser = userAdminRepository.findByUserName(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUserName(), applicationUser.getPassword(), emptyList());
    }

}
