package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.repo;

import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaderboardRepo extends JpaRepository<Leaderboard,Long> {
    @Query("SELECT l FROM Leaderboard l ORDER BY l.xp DESC")
    List<Leaderboard> findTopPlayers();


}
