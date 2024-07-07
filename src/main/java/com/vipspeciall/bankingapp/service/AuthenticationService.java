package com.vipspeciall.bankingapp.service;

import com.vipspeciall.bankingapp.config.JwtUtil;
import com.vipspeciall.bankingapp.dto.LoginRequest;
import com.vipspeciall.bankingapp.dto.UserDTO;
import com.vipspeciall.bankingapp.exception.UserAlreadyExistsException;
import com.vipspeciall.bankingapp.mapper.UserMapper;
import com.vipspeciall.bankingapp.model.User;
import com.vipspeciall.bankingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private UserService userService;


    public UserDTO registerUser(UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername()) || userRepository.existsByEmail(userDTO.getEmail())) {
            throw new UserAlreadyExistsException("Username or email already exists");
        }
        User user = userMapper.userDTOToUser(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return userMapper.userToUserDTO(userRepository.save(user));
    }

    public String login(LoginRequest loginRequest) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(), loginRequest.getPassword())
            );
            UserDetails userDetails = customUserDetailsService.loadUserByUsername((String) authentication.getPrincipal());
            String jwt = jwtUtil.generateToken(userDetails);
            return jwt;
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid username or password");
        }

    }
}
