package org.portfolio.englishproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.portfolio.englishproject.DTO.EditWordDTO;
import org.portfolio.englishproject.config.JwtUtil;
import org.portfolio.englishproject.model.Word;
import org.portfolio.englishproject.repository.WordRepository;
import org.portfolio.englishproject.repository.authRepo.UserRepository;
import org.portfolio.englishproject.service.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;
    private final UserRepository userRepository;


    @Override
    public ResponseEntity<List<Word>> getAllWords(String bearerToken) {
        List<Word> words = List.of(wordRepository.findByUser(userRepository.findByUsername(JwtUtil.getUsername(bearerToken)).get()));
        return ResponseEntity.ok(words);
    }

    @Override
    @Transactional
    public ResponseEntity<String> deleteWord(int id) {
        wordRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Word> editWord(EditWordDTO editWordDTO, String bearerToken) {
        Word word = editWordDTO.EditWordToWord(userRepository.findByUsername(JwtUtil.getUsername(bearerToken)).get());
        wordRepository.save(word);
        return ResponseEntity.ok().build();
    }
}
