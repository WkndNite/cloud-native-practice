package com.example.score.client;

import java.util.List;
import org.springframework.stereotype.Component;
import com.example.score.model.Score;
import com.example.score.model.ScoreReport;

@Component
public class ScoreServiceClientFallback implements ScoreServiceClient {
    @Override
    public List<Score> findAll() {
        return List.of();
    }

    @Override
    public Score findById(Integer id) {
        return null;
    }

    @Override
    public List<Score> findByStudentId(Integer studentId) {
        return List.of();
    }

    @Override
    public List<Score> findByCourseName(String courseName) {
        return List.of();
    }

    @Override
    public void addScore(Score score) {
    }

    @Override
    public void updateScore(Score score) {
    }

    @Override
    public void deleteScore(Integer id) {
    }

    @Override
    public Double getAverageScoreByStudentId(Integer studentId) {
        return 0.0;
    }

    @Override
    public Double getAverageScoreByCourseName(String courseName) {
        return 0.0;
    }

    @Override
    public ScoreReport generateScoreReport(Integer studentId) {
        return null;
    }
} 