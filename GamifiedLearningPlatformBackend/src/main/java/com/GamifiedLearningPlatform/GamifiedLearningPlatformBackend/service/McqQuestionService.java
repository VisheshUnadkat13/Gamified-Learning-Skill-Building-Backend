package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.service;

import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model.McqQuestion;
import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.repo.McqQuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class McqQuestionService {

    @Autowired
    private McqQuestionRepo mcqQuestionRepo;


    public List<McqQuestion> getAllMcqQuestion() {
        return mcqQuestionRepo.findAll();
    }

    public Optional<McqQuestion> getMcqQuestionById(Long id) {
        return mcqQuestionRepo.findById(id);
    }

    public void deleteMcqQuestion(Long id) {
        mcqQuestionRepo.deleteById(id);
    }
}
