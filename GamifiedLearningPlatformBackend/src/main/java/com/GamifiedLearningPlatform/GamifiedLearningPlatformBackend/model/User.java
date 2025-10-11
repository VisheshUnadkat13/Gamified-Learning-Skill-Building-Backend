package com.GamifiedLearningPlatform.GamifiedLearningPlatformBackend.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.persister.internal.PersisterFactoryInitiator;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String email;

    private String username;

    private String password;

    private String role="ROLE_USER";
}
