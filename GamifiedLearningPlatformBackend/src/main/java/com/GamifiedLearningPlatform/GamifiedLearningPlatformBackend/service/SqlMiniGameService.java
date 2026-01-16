package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.service;


import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model.SqlMinigGame;
import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.repo.SqlMiniGameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SqlMiniGameService {

    @Autowired
    private SqlMiniGameRepo sqlMiniGameRepo;


    public List<SqlMinigGame> getAllSqlQuestion() {
        return sqlMiniGameRepo.findAll();
    }

    public Optional<SqlMinigGame> getSqlMiniGameById(Long id) {
        return sqlMiniGameRepo.findById(id);
    }

    public void deleteSqlQuestion(Long id) {
        sqlMiniGameRepo.deleteById(id);
    }
}
