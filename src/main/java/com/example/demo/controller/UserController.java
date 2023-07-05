package com.example.demo.controller;

import com.example.demo.model.RegisterReq;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterReq req) {
        System.out.println("account: " + req.getAccount());
        System.out.println("password: " + req.getPassword());
        return "success";
    }

}
