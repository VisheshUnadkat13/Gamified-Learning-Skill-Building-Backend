package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.controller;

import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model.SqlMinigGame;
import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.service.SqlMiniGameService;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sql")
@CrossOrigin(origins = "http://localhost:5173")

public class SqlMiniGameController {

    @Autowired
    private SqlMiniGameService sqlMiniGameService;

    @GetMapping
    public ResponseEntity<List<SqlMinigGame>> getAllSqlQuestion() {
        return new ResponseEntity<>(sqlMiniGameService.getAllSqlQuestion(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<SqlMinigGame>> getSqlMiniGameById(@PathVariable Long id) {
        Optional<SqlMinigGame> sqlMinigGame = sqlMiniGameService.getSqlMiniGameById(id);
        if (sqlMinigGame.isPresent()) {
            return new ResponseEntity<>(sqlMinigGame, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSqlQuestion(@PathVariable Long id) {
        Optional<SqlMinigGame> sqlMinigGame = sqlMiniGameService.getSqlMiniGameById(id);
        if (sqlMinigGame.isPresent()) {
            sqlMiniGameService.deleteSqlQuestion(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> addSqlMiniGame(@RequestBody SqlMinigGame minigGame) {
        SqlMinigGame addMinigGame = null;

        try {
            addMinigGame = sqlMiniGameService.addMinigGame(minigGame);
            return new ResponseEntity<>(addMinigGame, HttpStatus.CREATED);
        }

        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}