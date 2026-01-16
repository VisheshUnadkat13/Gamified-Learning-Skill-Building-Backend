package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.controller;

import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model.FlashCard;
import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.service.FlashCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flashcards")
@CrossOrigin(origins = "http://localhost:5173")
public class FlashCardController {

    @Autowired
    private FlashCardService flashCardService;

    @GetMapping("/all")
    public ResponseEntity<List<FlashCard>> getAllFlashCard() {
        return new ResponseEntity<>(flashCardService.getAllFlashCards(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<FlashCard>> getFlashCardById(@PathVariable Long id) {
        Optional<FlashCard> flashCard = flashCardService.getFlashCardById(id);

        if (flashCard.isPresent()) {
            return new ResponseEntity<>(flashCard, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/language/{lang}")
    public ResponseEntity<List<FlashCard>> getByLanguage(@PathVariable String lang) {
        return new ResponseEntity<>(flashCardService.getByLanguage(lang), HttpStatus.OK);
    }

    @GetMapping(" ")
    public ResponseEntity<List<FlashCard>> getByDifficulty(@PathVariable String level) {
        return new ResponseEntity<>(flashCardService.getByDifficulty(level), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addFlashCard(@RequestBody FlashCard card) {
        FlashCard addFlashCard = null;
        try {
            addFlashCard = flashCardService.addFlashCard(card);
            return new ResponseEntity<>(addFlashCard, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
