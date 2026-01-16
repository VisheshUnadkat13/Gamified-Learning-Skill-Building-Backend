package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.controller;

import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model.CodingChallenges;
import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.service.CodingChallengesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/challenges")
@CrossOrigin(origins = "http://localhost:5173")
public class CodingChallengesController {

    @Autowired
    private CodingChallengesService service;

    @GetMapping
    public ResponseEntity<List<CodingChallenges>> getAllCodingChallenges()
    {
        return new ResponseEntity<>(service.getAllChallenges(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?>addChallenges(@RequestBody CodingChallenges challenges)
    {
        CodingChallenges savedChallenges=null;

        try{
            savedChallenges=service.addCheallenges(challenges);
            return new ResponseEntity<>(challenges,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CodingChallenges>> getChallengesById(@PathVariable Integer id)
    {
        Optional<CodingChallenges> codingChallenges=service.getChallengesById(id);
        if(codingChallenges.isPresent())
        {
            return new ResponseEntity<>(codingChallenges,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenges(@PathVariable Integer id)
    {
        Optional<CodingChallenges> codingChallenges=service.getChallengesById(id);

        if(codingChallenges.isPresent())
        {
            service.deleteChallenge(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
