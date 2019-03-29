package com.example.demo.security.controllers;

import com.example.demo.security.domains.UserAdmin;
import com.example.demo.security.repositories.UserAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserAdminController {

    @Autowired
    private UserAdminRepository userAdminRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("sign-in")
    public void signUp(@RequestBody UserAdmin user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userAdminRepository.save(user);
    }

}

