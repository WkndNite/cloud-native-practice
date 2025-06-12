package com.example.score.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Score {
    private Integer id;
    private Integer studentId;
    private String courseName;
    private Double score;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 