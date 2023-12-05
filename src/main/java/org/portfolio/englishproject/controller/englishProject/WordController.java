package org.portfolio.englishproject.controller.englishProject;

import lombok.RequiredArgsConstructor;
import org.portfolio.englishproject.DTO.EditWordDTO;
import org.portfolio.englishproject.model.Word;
import org.portfolio.englishproject.service.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class WordController {

    private final WordService service;

    @GetMapping("/getAllWords")
    public ResponseEntity<List<Word>> getAllWords(@RequestHeader("Authorization") String bearerToken){
        return service.getAllWords(bearerToken);
    }


    @DeleteMapping("/deleteWord/{id}")
    public ResponseEntity<String> deleteWord(@PathVariable int id){
        return service.deleteWord(id);
    }
    @PutMapping("/editWord")
    public ResponseEntity<Word> editWord(@RequestBody EditWordDTO editWordDTO, @RequestHeader("Authorization") String bearerToken){
        return service.editWord(editWordDTO, bearerToken);
    }

}
