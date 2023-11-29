package org.portfolio.englishproject.service.user;

import lombok.RequiredArgsConstructor;
import org.portfolio.englishproject.config.JwtUtil;
import org.portfolio.englishproject.repository.authRepo.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;//TODO: PROBABLY NEED TO DELETE THIS AND CONTROLLER

    public int getUserId(String bearerToken){
        String username = JwtUtil.getUsername(bearerToken);
        return repository.findByUsername(username).get().getId();
    }

}
