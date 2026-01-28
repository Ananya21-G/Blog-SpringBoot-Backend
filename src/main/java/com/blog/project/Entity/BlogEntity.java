package com.blog.project.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="blogs")
public class BlogEntity {

    @Id
    @GeneratedValue
    private UUID Id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "Text" , nullable = false)
    private String content;

    @Column(length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    private Mood mood;

    @CreationTimestamp
    private LocalDateTime CreatedAt;
}
