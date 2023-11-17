package org.portfolio.englishproject.controller;

import lombok.RequiredArgsConstructor;
import org.portfolio.englishproject.model.Word;
import org.portfolio.englishproject.repository.EnglishTrainingRepository;
import org.portfolio.englishproject.service.EnglishTrainingService;
import org.portfolio.englishproject.service.impl.EnglishTrainingServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EnglishTrainingController {

    //This site was made for my girlfriend, who broke up with me, because she went to another country.
    // I hope she will be happy. I love you. I will never forget you. David 17.11.2023
    private final EnglishTrainingServiceImpl service;

    @GetMapping("/getAllWords")
    public ResponseEntity<List<Word>> getAllWords(){
        return service.getAllWords();
    }


    @PostMapping("/sendWord")
    public ResponseEntity<Word> sendWord(@RequestBody Word word){//TODO: fix this
        return service.sendWord(word);
    }

    @PostMapping("/sendFile")
    public ResponseEntity<List<Word>> sendFile(@RequestBody MultipartFile file ) {
        return service.sendFile(file);
    }

    @GetMapping("/game")
    public ResponseEntity<Word> game(){
        return service.gameGetText();
    }

    @PostMapping("/game")
    public ResponseEntity<String> gameCheck(@RequestBody Word word, @RequestParam("translate") String translate){
        return service.gameCheck(word, translate);
    }

}
