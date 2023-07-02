package com.example.demo.model;

import com.example.demo.annotation.ValidatePassword;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;


@Getter
public class RegisterReq {

    @NotBlank
    private String account;

    @NotBlank
    @ValidatePassword
    private String password;

}
