package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.repo;

import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model.FlashCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlashCardRepo extends JpaRepository<FlashCard,Long> {
    List<FlashCard> findByLanguageIgnoreCase(String lang);

    List<FlashCard> findByDifficulty(String level);
}
