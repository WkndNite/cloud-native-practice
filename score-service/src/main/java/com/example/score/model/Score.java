package com.example.score.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Score {
    private Integer enrollmentId;
    private Integer studentId;
    private Integer courseId;
    private Double grade;
    private LocalDateTime enrolledAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    // 关联查询的额外字段
    private String studentName;
    private String courseName;
    private String courseType;
    private Double credit;
} 