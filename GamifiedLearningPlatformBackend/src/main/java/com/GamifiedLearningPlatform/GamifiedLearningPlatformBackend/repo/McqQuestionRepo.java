package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.repo;

import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model.McqQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface McqQuestionRepo extends JpaRepository<McqQuestion,Long> {
}
