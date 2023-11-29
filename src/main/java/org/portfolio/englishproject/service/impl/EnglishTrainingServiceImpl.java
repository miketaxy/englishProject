package org.portfolio.englishproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.portfolio.englishproject.DTO.SendWordDTO;
import org.portfolio.englishproject.config.JwtUtil;
import org.portfolio.englishproject.model.Word;
import org.portfolio.englishproject.repository.EnglishTrainingRepository;
import org.portfolio.englishproject.repository.authRepo.UserRepository;
import org.portfolio.englishproject.service.EnglishTrainingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EnglishTrainingServiceImpl implements EnglishTrainingService {
    private final EnglishTrainingRepository repository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<String> makeCategory() {
        return null;
    }

    @Override
    public ResponseEntity<List<Word>> getAllWords(String bearerToken) {
        List<Word> words = List.of(repository.findByUser(userRepository.findByUsername(JwtUtil.getUsername(bearerToken)).get()));
        return ResponseEntity.ok(words);
    }

    @Override
    @Transactional
    public ResponseEntity<String> deleteWord(String word, String translate) {
        repository.deleteByWordAndTranslate(word, translate);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Word> editWord(Word word, String bearerToken) {
        repository.save(word);
        return ResponseEntity.ok().build();
    }
}
