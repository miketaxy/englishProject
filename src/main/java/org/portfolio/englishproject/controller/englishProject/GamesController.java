package org.portfolio.englishproject.controller.englishProject;

import lombok.RequiredArgsConstructor;
import org.portfolio.englishproject.DTO.SendWordDTO;
import org.portfolio.englishproject.service.GamesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GamesController {

    private final GamesService service;
    @GetMapping("/game")
    public ResponseEntity<SendWordDTO> game(@RequestHeader("Authorization") String bearerToken){
        return service.gameGetText(bearerToken);
    }

    @PostMapping("/game")
    public ResponseEntity<String> gameCheck(@RequestBody SendWordDTO sendWordDTO, @RequestParam("translate") String translate){
        return service.gameCheck(sendWordDTO, translate);
    }
}
