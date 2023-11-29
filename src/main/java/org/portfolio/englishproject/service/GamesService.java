package org.portfolio.englishproject.service;

import org.portfolio.englishproject.model.Word;
import org.springframework.http.ResponseEntity;

public interface GamesService {
    ResponseEntity<Word> gameGetText();

    ResponseEntity<String> gameCheck(Word word, String translate);
}
