package org.portfolio.englishproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.portfolio.englishproject.DTO.SendWordDTO;
import org.portfolio.englishproject.config.JwtUtil;
import org.portfolio.englishproject.model.Word;
import org.portfolio.englishproject.repository.EnglishTrainingRepository;
import org.portfolio.englishproject.repository.authRepo.UserRepository;
import org.portfolio.englishproject.service.SendFileService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SendFileServiceImpl implements SendFileService {
    private final EnglishTrainingRepository repository;
    private final UserRepository userRepository;
    @Override
    public ResponseEntity<Word> sendWord(SendWordDTO sendWord, String bearerToken) {
        Word word = sendWord.makeWord(userRepository.findByUsername(JwtUtil.getUsername(bearerToken)).get());
        repository.save(word);
        return ResponseEntity.ok(word);
    }

    @Override
    public ResponseEntity<List<Word>> sendFile(MultipartFile file, String bearerToken) {
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
                words.add(new SendWordDTO(word.toString().trim(), translate.toString().trim()).makeWord(userRepository.findByUsername(JwtUtil.getUsername(bearerToken)).get()));
            }
            repository.saveAll(words);
            return ResponseEntity.ok(words);
        }catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.ofNullable(null);
        }

    }
}
