package org.portfolio.englishproject.service;

import org.portfolio.englishproject.DTO.SendWordDTO;
import org.springframework.http.ResponseEntity;

public interface GamesService {
    ResponseEntity<SendWordDTO> gameGetText(String bearerToken);

    ResponseEntity<String> gameCheck(SendWordDTO word, String translate);
}
