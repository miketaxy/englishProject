package org.portfolio.englishproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;


@Data
@Table(name="Words")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String category;

    private String word;

    private String translate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
