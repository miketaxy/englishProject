package org.portfolio.englishproject.service;

import org.portfolio.englishproject.model.Word;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public interface EnglishTrainingService {
    ResponseEntity<Word> sendWord(Word word);

    ResponseEntity<List<Word>> sendFile(MultipartFile file);

    ResponseEntity<Word> gameGetText();

    ResponseEntity<String> gameCheck(Word word, String translate);

    ResponseEntity<String> makeCategory();

    ResponseEntity<List<Word>> getAllWords();
}
