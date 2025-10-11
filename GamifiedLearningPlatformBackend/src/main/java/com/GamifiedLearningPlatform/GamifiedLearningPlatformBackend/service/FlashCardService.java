package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.service;

import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model.FlashCard;
import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.repo.FlashCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlashCardService {



    @Autowired
    private FlashCardRepo flashCardRepo;


    public List<FlashCard> getAllFlashCards() {
        return flashCardRepo.findAll();
    }

    public Optional<FlashCard> getFlashCardById(Long id) {
        return flashCardRepo.findById(id);
    }

    public List<FlashCard> getByLanguage(String lang) {
        return flashCardRepo.findByLanguageIgnoreCase(lang);
    }

    public List<FlashCard> getByDifficulty(String level) {
        return flashCardRepo.findByDifficulty(level);
    }
}
