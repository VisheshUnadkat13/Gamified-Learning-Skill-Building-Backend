package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.repo;

import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model.SqlMinigGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlMiniGameRepo extends JpaRepository<SqlMinigGame,Long> {
    List<SqlMinigGame> findByDifficulty(String diff);

    List<SqlMinigGame> findByCategory(String category);

    List<SqlMinigGame> findByXpReward(Integer xp);
}
