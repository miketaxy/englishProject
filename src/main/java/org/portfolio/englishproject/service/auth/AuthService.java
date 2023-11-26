package org.portfolio.englishproject.service.auth;

import lombok.RequiredArgsConstructor;
import org.portfolio.englishproject.config.AuthenticationResponse;

import org.portfolio.englishproject.config.JwtUtil;
import org.portfolio.englishproject.model.LoginUser;
import org.portfolio.englishproject.repository.authRepo.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService{
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse loginUser(LoginUser request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = JwtUtil.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse registerUser(LoginUser request) {
        String passwordEncode = passwordEncoder.encode(request.getPassword());
        var user = userRepository.save(request.toUser(passwordEncode));
        var jwtToken = JwtUtil.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
