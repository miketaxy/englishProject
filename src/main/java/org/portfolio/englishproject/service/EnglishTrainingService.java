package org.portfolio.englishproject.service;

import org.portfolio.englishproject.DTO.SendWordDTO;
import org.portfolio.englishproject.model.Word;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface EnglishTrainingService {


    ResponseEntity<String> makeCategory();

    ResponseEntity<List<Word>> getAllWords(String header);

    ResponseEntity<String> deleteWord(String word, String translate);

    ResponseEntity<Word> editWord(Word word, String header);
}
