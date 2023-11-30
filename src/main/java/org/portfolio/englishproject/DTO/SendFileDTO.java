package org.portfolio.englishproject.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SendFileDTO {
    private MultipartFile file;
    private String category;
}
