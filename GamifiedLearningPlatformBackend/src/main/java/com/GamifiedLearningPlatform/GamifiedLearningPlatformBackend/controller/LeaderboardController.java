package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.controller;

import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model.Leaderboard;
import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/leaderboard")
@CrossOrigin(origins = "http://localhost:5174")
public class LeaderboardController {

    @Autowired
    private LeaderboardService leaderboardService;

    @GetMapping("/top")
    public ResponseEntity<List<Leaderboard>> getTopPlayers()
    {
        return new ResponseEntity<>(leaderboardService.getTopPlayer(), HttpStatus.OK);
    }

}
