package com.vipspeciall.bankingapp.controller;

import com.vipspeciall.bankingapp.config.JwtUtil;
import com.vipspeciall.bankingapp.model.User;
import com.vipspeciall.bankingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    protected User getUser(HttpServletRequest request) {

        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;
        User user = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
            user = userService.findByUsername(username);
        }

        return user;

    }

}
