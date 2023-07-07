package com.example.demo.controller;

import com.example.demo.model.ApiResult;
import com.example.demo.model.RegisterReq;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class UserController {

    @PostMapping("/user")
    public ResponseEntity<ApiResult> register(@Valid @RequestBody RegisterReq req) {
        // do some create user process here
        return ResponseEntity.ok(new ApiResult(HttpStatus.OK.value(), "success"));
    }

}
