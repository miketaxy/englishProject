package org.portfolio.englishproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Table(name="Words")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
//    String category;

    String word;

    String translate;
//    int user_id;//TODO user_id and category

    public Word(String word, String translate) {
        this.word = word;
        this.translate = translate;
    }
}
