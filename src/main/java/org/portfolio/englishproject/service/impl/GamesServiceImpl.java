package org.portfolio.englishproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.portfolio.englishproject.model.Word;
import org.portfolio.englishproject.repository.EnglishTrainingRepository;
import org.portfolio.englishproject.service.GamesService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class GamesServiceImpl implements GamesService {
    private final EnglishTrainingRepository repository;
    @Override
    public ResponseEntity<Word> gameGetText() {
        List<Word> words = repository.findAll();
        Random random = new Random();
        int index = random.nextInt(words.size());
        return ResponseEntity.ok(words.get(index));
    }

    @Override
    public ResponseEntity<String> gameCheck(Word word, String translate) {
        if(word.getTranslate().equals(translate)){
            return ResponseEntity.ok("true");
        }
        return ResponseEntity.ok("false");
    }
}
