package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.repo;

import com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model.BugHunter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugHunterRepo extends JpaRepository<BugHunter,Long> {
}
