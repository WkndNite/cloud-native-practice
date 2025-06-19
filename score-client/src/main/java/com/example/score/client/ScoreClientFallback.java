package com.example.score.client;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import com.example.score.model.Score;
import com.example.score.model.ScoreReport;

@Component
public class ScoreClientFallback implements ScoreClient {
    @Override
    public List<Score> getAllScores() {
        return new ArrayList<>();
    }

    @Override
    public Score getScoreById(Integer id) {
        return null;
    }

    @Override
    public List<Score> getScoresByStudent(Integer studentId) {
        return new ArrayList<>();
    }

    @Override
    public List<Score> getScoresByCourse(Integer courseId) {
        return new ArrayList<>();
    }

    @Override
    public void addScore(Score score) {
    }

    @Override
    public void updateScore(Integer id, Score score) {
    }

    @Override
    public void deleteScore(Integer id) {
    }

    @Override
    public Double getAverageScoreByStudent(Integer studentId) {
        return 0.0;
    }

    @Override
    public Double getAverageScoreByCourse(Integer courseId) {
        return 0.0;
    }

    @Override
    public ScoreReport getScoreReport(Integer studentId) {
        return null;
    }
} 