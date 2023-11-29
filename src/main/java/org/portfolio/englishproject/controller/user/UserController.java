package org.portfolio.englishproject.controller.user;


import lombok.RequiredArgsConstructor;
import org.portfolio.englishproject.service.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/getUserId")
    public int getUserId(@RequestHeader("Authorization") String bearerToken){
        return service.getUserId(bearerToken);
    }
}
