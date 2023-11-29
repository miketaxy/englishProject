package org.portfolio.englishproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.portfolio.englishproject.model.User;
import org.portfolio.englishproject.model.Word;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendWordDTO {
    private String word;
    private String translate;


    public Word makeWord(User user){
        return Word.builder()
                .word(word)
                .translate(translate)
                .user(user)
                .build();
    }
}
