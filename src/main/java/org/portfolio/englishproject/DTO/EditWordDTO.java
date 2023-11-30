package org.portfolio.englishproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.portfolio.englishproject.model.User;
import org.portfolio.englishproject.model.Word;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EditWordDTO {
    private int id;

    private String category;

    private String word;

    private String translate;


    public Word EditWordToWord(User user){
        return Word.builder()
                .id(id)
                .word(word)
                .translate(translate)
                .user(user)
                .build();
    }
}

