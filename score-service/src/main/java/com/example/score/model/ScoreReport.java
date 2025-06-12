package com.example.score.model;

import java.util.List;
import com.example.score.model.Score;
import lombok.Data;

@Data
public class ScoreReport {
    private Integer studentId;
    private List<Score> scores;
    private Double averageScore;
    private Double totalScore;
    private Integer courseCount;
    private Double highestScore;
    private Double lowestScore;
} 