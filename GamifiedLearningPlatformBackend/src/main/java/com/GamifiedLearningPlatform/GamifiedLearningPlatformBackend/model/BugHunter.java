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

public class BugHunter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name="buggy_code",columnDefinition = "TEXT")
    private String buggyCode;

    @Column(name = "fixed_code",columnDefinition = "TEXT")
    private String fixedCode;

    private String language;

    private String difficulty;

    @ElementCollection
    @CollectionTable(name = "bug_challenge_hints", joinColumns = @JoinColumn(name = "challenge_id"))
    @Column(name = "hint")
    private List<String> hints;

    @Column(columnDefinition = "TEXT")
    private String explanation;

    private String category;


}
