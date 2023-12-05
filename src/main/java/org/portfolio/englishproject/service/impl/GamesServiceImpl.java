package org.portfolio.englishproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.portfolio.englishproject.DTO.SendWordDTO;
import org.portfolio.englishproject.config.JwtUtil;
import org.portfolio.englishproject.model.User;
import org.portfolio.englishproject.model.Word;
import org.portfolio.englishproject.repository.WordRepository;
import org.portfolio.englishproject.repository.authRepo.UserRepository;
import org.portfolio.englishproject.service.GamesService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class GamesServiceImpl implements GamesService {
    private final WordRepository wordRepository;
    private final UserRepository userRepository;
    @Override
    public ResponseEntity<SendWordDTO> gameGetText(String bearerToken) {
        List<Word> words = List.of(wordRepository.findByUser(getUser(bearerToken)));
        Random random = new Random();
        int index = random.nextInt(words.size());
        return ResponseEntity.ok(new SendWordDTO(words.get(index).getWord(), words.get(index).getTranslate()));
    }

    @Override
    public ResponseEntity<String> gameCheck(SendWordDTO sendWordDTO, String translate) {
        if(sendWordDTO.getTranslate().equalsIgnoreCase(translate.trim())){
            return ResponseEntity.ok("true");
        }
        return ResponseEntity.ok("false");
    }

    private User getUser(String bearerToken){
        return userRepository.findByUsername(JwtUtil.getUsername(bearerToken)).get();
    }
}
