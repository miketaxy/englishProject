package org.portfolio.englishproject.service;

import org.portfolio.englishproject.DTO.EditWordDTO;
import org.portfolio.englishproject.model.Word;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WordService {

    ResponseEntity<List<Word>> getAllWords(String header);

    ResponseEntity<String> deleteWord(int id);

    ResponseEntity<Word> editWord(EditWordDTO editWordDTO, String header);


}
