package com.blog.project.Entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum Mood {
    @Enumerated(EnumType.STRING)
        HAPPY,
        SAD,
        THOUGHTFUL,
        MOTIVATIONAL,
        DARK,
        CALM
    }
