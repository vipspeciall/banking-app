package com.vipspeciall.bankingapp.controller;

import com.vipspeciall.bankingapp.dto.LoginRequest;
import com.vipspeciall.bankingapp.dto.UserDTO;
import com.vipspeciall.bankingapp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
        UserDTO newUser = authenticationService.registerUser(userDTO);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String result = authenticationService.login(loginRequest);
        return ResponseEntity.ok(result);
    }
}
