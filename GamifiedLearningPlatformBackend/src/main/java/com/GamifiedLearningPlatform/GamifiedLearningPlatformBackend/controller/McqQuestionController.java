package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.controller;

import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model.McqQuestion;
import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.service.McqQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mcq")
@CrossOrigin(origins = "http://localhost:5173")
public class McqQuestionController {

    @Autowired
    private McqQuestionService mcqQuestionService;

    @GetMapping("/all")
    public ResponseEntity<List<McqQuestion>> getAllMcqQuestion()
    {
        return new ResponseEntity<>(mcqQuestionService.getAllMcqQuestion(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<McqQuestion>> getMcqQuestionById(@PathVariable Long id)
    {
        Optional<McqQuestion> mcqQuestion=mcqQuestionService.getMcqQuestionById(id);
        if(mcqQuestion.isPresent())
        {
            return new ResponseEntity<>(mcqQuestion,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMcqQuestion(@PathVariable Long id)
    {
        Optional<McqQuestion> mcqQuestion=mcqQuestionService.getMcqQuestionById(id);
        if(mcqQuestion.isPresent())
        {
            mcqQuestionService.deleteMcqQuestion(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
