package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sql_mini_game")
public class SqlMinigGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String tableSchema;

    @Column(columnDefinition = "TEXT")
    private String question;

    @Column(columnDefinition = "TEXT")
    private String expectedOutput;

    @Column(columnDefinition = "TEXT")
    private String expectedQuery;

    @Column(length = 20)
   private String difficulty;

    @Column(name = "xp_reward")
    private Integer xpReward;

    @Column(length = 50)
    private String category;

    @ElementCollection
    @CollectionTable(name = "sql_challenge_hints", joinColumns = @JoinColumn(name = "challenge_id"))
    @Column(name = "hint", columnDefinition = "TEXT")
    private List<String> hints; // Optional hints

    @Column(columnDefinition = "TEXT")
    private String explanation;

}
