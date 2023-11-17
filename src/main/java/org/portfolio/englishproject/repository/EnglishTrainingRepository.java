package org.portfolio.englishproject.repository;

import org.portfolio.englishproject.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnglishTrainingRepository extends JpaRepository<Word, Integer> {
    Optional<Word> findByWordAndTranslate(String word, String translate);
}
