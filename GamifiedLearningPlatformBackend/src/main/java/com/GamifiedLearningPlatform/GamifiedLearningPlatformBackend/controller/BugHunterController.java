package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.controller;

import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model.BugHunter;
import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.service.BugHunterService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bughunter")
@CrossOrigin(origins = "http://localhost:5174")
public class BugHunterController {

    @Autowired
    private BugHunterService bugHunterService;

    @GetMapping("/all")
    public ResponseEntity<List<BugHunter>> getAllBugChallenges()
    {
        return new ResponseEntity<>(bugHunterService.getAllBugChallenges(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BugHunter>> getBugChallengesById(@PathVariable Long id)
    {
        Optional<BugHunter> bugHunter=bugHunterService.getBugChallengesById(id);
        if(bugHunter.isPresent())
        {
            return new ResponseEntity<>(bugHunter,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBugChallenge(@PathVariable Long id)
    {
        Optional<BugHunter> bugHunter=bugHunterService.getBugChallengesById(id);

        if(bugHunter.isPresent())
        {
            bugHunterService.deleteBugChallenge(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?>addBugChaleenges(@RequestBody BugHunter bugHunter)
    {
        BugHunter savedBugChllenges=null;
        try{
            savedBugChllenges=bugHunterService.addBugChallenges(bugHunter);
            return new ResponseEntity<>(savedBugChllenges,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CREATED);
        }
    }


}
