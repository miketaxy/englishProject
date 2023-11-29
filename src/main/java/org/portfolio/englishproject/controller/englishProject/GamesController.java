package org.portfolio.englishproject.controller.englishProject;

import lombok.RequiredArgsConstructor;
import org.portfolio.englishproject.model.Word;
import org.portfolio.englishproject.service.GamesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GamesController {

    private final GamesService service;
    @GetMapping("/game")
    public ResponseEntity<Word> game(){
        return service.gameGetText();
    }

    @PostMapping("/game")
    public ResponseEntity<String> gameCheck(@RequestBody Word word, @RequestParam("translate") String translate){
        return service.gameCheck(word, translate);
    }
}
