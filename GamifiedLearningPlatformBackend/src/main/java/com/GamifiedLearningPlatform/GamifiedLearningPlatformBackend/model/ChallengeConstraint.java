package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class ChallengeConstraint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="challenge_id")
    private CodingChallenges challenge;

    @Column(name = "constraint_text", columnDefinition = "TEXT")
    private String constraintText;

}
