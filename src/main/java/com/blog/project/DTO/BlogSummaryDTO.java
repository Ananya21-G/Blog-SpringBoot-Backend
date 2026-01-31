package com.blog.project.DTO;

import com.blog.project.Entity.Mood;

import java.time.LocalDateTime;
import java.util.UUID;

public class BlogSummaryDTO {

    private UUID id;
    private String title;
    private String description;
    private Mood mood;
    private LocalDateTime createdAt;

    public BlogSummaryDTO(
            UUID id,
            String title,
            String description,
            Mood mood,
            LocalDateTime createdAt) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.mood = mood;
        this.createdAt = createdAt;
    }

    // getters only (read-only DTO)
    public UUID getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Mood getMood() { return mood; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
