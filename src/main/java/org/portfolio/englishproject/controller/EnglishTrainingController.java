package org.portfolio.englishproject.controller;

import lombok.RequiredArgsConstructor;
import org.portfolio.englishproject.model.Word;
import org.portfolio.englishproject.service.impl.EnglishTrainingServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EnglishTrainingController {

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
    @DeleteMapping("/deleteWord")
    public ResponseEntity<String> deleteWord(@RequestParam("word") String word, @RequestParam("translate") String translate){
        System.out.println("deleteWord");
        return service.deleteWord(word, translate);
    }
    @PutMapping("/editWord")
    public ResponseEntity<Word> editWord(@RequestBody Word word){
        System.out.println("editWord");
        return service.editWord(word);
    }

}
