package org.portfolio.englishproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.portfolio.englishproject.model.Word;
import org.portfolio.englishproject.repository.EnglishTrainingRepository;
import org.portfolio.englishproject.service.EnglishTrainingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class EnglishTrainingServiceImpl implements EnglishTrainingService {
    private final EnglishTrainingRepository repository;
    @Override
    public ResponseEntity<Word> sendWord(Word word) {
        repository.save(word);
        return ResponseEntity.ok(word);
    }

    @Override
    public ResponseEntity<List<Word>> sendFile(MultipartFile file) {
        try {
            List<Word> words = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line;
            while((line = reader.readLine()) != null){
                boolean isTranslate = false;
                StringBuilder word = new StringBuilder();
                StringBuilder translate = new StringBuilder();
                for(int i = 0; i < line.length(); i++){
                    if (line.charAt(i) != '-'){
                        if(!isTranslate){
                            word.append(line.charAt(i));
                        }
                        else{
                            translate.append(line.charAt(i));
                        }
                    }
                    else{
                        isTranslate = true;
                    }
                }
                words.add(new Word(word.toString().trim(), translate.toString().trim()));
            }
            repository.saveAll(words);
            return ResponseEntity.ok(words);
        }catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.ofNullable(null);
        }

    }

    @Override
    public ResponseEntity<Word> gameGetText() {
        List<Word> words = repository.findAll();
        Random random = new Random();
        int index = random.nextInt(0,words.size());
        return ResponseEntity.ok(words.get(index));
    }

    @Override
    public ResponseEntity<String> gameCheck(Word word, String translate) {
        if(word.getTranslate().equals(translate)){
            return ResponseEntity.ok("true");
        }
        return ResponseEntity.ok("false");
    }

    @Override
    public ResponseEntity<String> makeCategory() {
        return null;
    }

    @Override
    public ResponseEntity<List<Word>> getAllWords() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Override
    @Transactional
    public ResponseEntity<String> deleteWord(String word, String translate) {
        repository.deleteByWordAndTranslate(word, translate);
        return ResponseEntity.ok("deleted");
    }

    @Override
    public ResponseEntity<Word> editWord(Word word) {
        System.out.println(word);
        repository.save(word);
        return ResponseEntity.ok(word);
    }
}
