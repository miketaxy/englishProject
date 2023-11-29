package org.portfolio.englishproject.controller.englishProject;

import lombok.RequiredArgsConstructor;
import org.portfolio.englishproject.DTO.SendWordDTO;
import org.portfolio.englishproject.model.Word;
import org.portfolio.englishproject.service.EnglishTrainingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EnglishTrainingController {

    private final EnglishTrainingService service;

    @GetMapping("/getAllWords")
    public ResponseEntity<List<Word>> getAllWords(@RequestHeader("Authorization") String bearerToken){
        return service.getAllWords(bearerToken);
    }


    @DeleteMapping("/deleteWord")
    public ResponseEntity<String> deleteWord(@RequestParam("word") String word, @RequestParam("translate") String translate){
        System.out.println("deleteWord");
        return service.deleteWord(word, translate);
    }
    @PutMapping("/editWord")
    public ResponseEntity<Word> editWord(@RequestBody Word word, @RequestHeader("Authorization") String bearerToken){
        return service.editWord(word, bearerToken);
    }

}
