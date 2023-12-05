package org.portfolio.englishproject.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@Table(name="words")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String word;

    private String translate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Word(String word, String translate, User user) {
        this.word = word;
        this.translate = translate;
        this.user = user;
    }

}
