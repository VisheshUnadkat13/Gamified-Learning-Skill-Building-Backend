package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.service;

import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model.CodingChallenges;
import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.repo.CodingChallengesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CodingChallengesService {

    @Autowired
    private CodingChallengesRepo repo;

    public List<CodingChallenges> getAllChallenges() {
        return repo.findAll();
    }

    public CodingChallenges addCheallenges(CodingChallenges challenges) {
        return repo.save(challenges);
    }

    public Optional<CodingChallenges> getChallengesById(Integer id) {
        return repo.findById(id);
    }


    public void deleteChallenge(Integer id) {
        repo.deleteById(id);
    }
}
