package org.portfolio.englishproject.controller.englishProject;

import lombok.RequiredArgsConstructor;
import org.portfolio.englishproject.DTO.SendWordDTO;
import org.portfolio.englishproject.model.Word;
import org.portfolio.englishproject.service.SendFileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SendFileController {
    private final SendFileService service;
    @PostMapping("/sendWord")
    public ResponseEntity<Word> sendWord(@RequestBody SendWordDTO sendWord, @RequestHeader("Authorization") String bearerToken){
        return service.sendWord(sendWord, bearerToken);
    }

    @PostMapping("/sendFile")
    public ResponseEntity<List<Word>> sendFile(@RequestBody MultipartFile file, @RequestHeader("Authorization") String bearerToken){
        return service.sendFile(file, bearerToken);
    }
}
