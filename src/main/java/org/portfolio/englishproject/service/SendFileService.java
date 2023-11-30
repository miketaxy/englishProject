package org.portfolio.englishproject.service;

import org.portfolio.englishproject.DTO.SendFileDTO;
import org.portfolio.englishproject.DTO.SendWordDTO;
import org.portfolio.englishproject.model.Word;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SendFileService {
    ResponseEntity<Word> sendWord(SendWordDTO sendWordDTO, String bearerToken);

    ResponseEntity<List<Word>> sendFile(SendFileDTO sendFileDTO, String bearerToken);
}
