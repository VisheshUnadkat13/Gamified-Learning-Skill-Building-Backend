package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.service;

import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model.Leaderboard;
import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.repo.LeaderboardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {

    @Autowired
    private LeaderboardRepo leaderboardRepo;

    public List<Leaderboard> getTopPlayer() {
        return leaderboardRepo.findTopPlayers();
    }
}
