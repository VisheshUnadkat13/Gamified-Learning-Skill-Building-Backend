package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.repo;

import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model.SqlMinigGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlMiniGameRepo extends JpaRepository<SqlMinigGame,Long> {
}
