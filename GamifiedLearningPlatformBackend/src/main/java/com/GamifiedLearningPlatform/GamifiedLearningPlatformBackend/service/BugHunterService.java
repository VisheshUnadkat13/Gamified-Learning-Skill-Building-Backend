package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.service;

import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model.BugHunter;
import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.repo.BugHunterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BugHunterService {

    @Autowired
    private BugHunterRepo bugHunterRepo;


    public List<BugHunter> getAllBugChallenges() {
        return bugHunterRepo.findAll();
    }

    public Optional<BugHunter> getBugChallengesById(Long id) {
        return bugHunterRepo.findById(id);
    }

    public void deleteBugChallenge(Long id) {
        bugHunterRepo.deleteById(id);
    }

    public BugHunter addBugChallenges(BugHunter bugHunter) {
        return bugHunterRepo.save(bugHunter);
    }
}
