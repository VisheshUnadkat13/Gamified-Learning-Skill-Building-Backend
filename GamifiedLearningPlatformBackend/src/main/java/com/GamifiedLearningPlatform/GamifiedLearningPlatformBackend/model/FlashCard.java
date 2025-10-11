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
@Table(name="flashcard_question")
public class FlashCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String code;

    @ElementCollection
    @CollectionTable(name = "flashcard_options", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "option_text", columnDefinition = "TEXT")
    private List<String> options;

    @Column(nullable = false)
    private Integer correct;

    @Column(columnDefinition = "TEXT")
    private String explanation;

    @Column(nullable = false,length=50)
    private String language;

    @Column(nullable = false,length = 20)
    private String difficulty;
}
