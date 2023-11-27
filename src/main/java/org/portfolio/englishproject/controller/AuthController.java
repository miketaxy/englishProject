package org.portfolio.englishproject.controller;

import lombok.RequiredArgsConstructor;
import org.portfolio.englishproject.model.LoginUser;

import org.portfolio.englishproject.service.auth.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginUser loginUser){
        return ResponseEntity.ok(authService.loginUser(loginUser));
    }

    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser){
        return ResponseEntity.ok(authService.registerUser(loginUser));
    }
}
