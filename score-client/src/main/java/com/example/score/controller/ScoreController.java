package com.example.score.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.score.model.Score;
import com.example.score.model.ScoreReport;
import com.example.score.client.ScoreClient;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {
    
    @Autowired
    private ScoreClient scoreClient;

    @GetMapping
    public List<Score> getAllScores() {
        return scoreClient.getAllScores();
    }

    @GetMapping("/{id}")
    public Score getScoreById(@PathVariable("id") Integer id) {
        return scoreClient.getScoreById(id);
    }

    @GetMapping("/student/{studentId}")
    public List<Score> getScoresByStudent(@PathVariable("studentId") Integer studentId) {
        return scoreClient.getScoresByStudent(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<Score> getScoresByCourse(@PathVariable("courseId") Integer courseId) {
        return scoreClient.getScoresByCourse(courseId);
    }

    @PostMapping
    public void addScore(@RequestBody Score score) {
        scoreClient.addScore(score);
    }

    @PutMapping("/{id}")
    public void updateScore(@PathVariable("id") Integer id, @RequestBody Score score) {
        scoreClient.updateScore(id, score);
    }

    @DeleteMapping("/{id}")
    public void deleteScore(@PathVariable("id") Integer id) {
        scoreClient.deleteScore(id);
    }

    @GetMapping("/student/{studentId}/average")
    public Double getAverageScoreByStudent(@PathVariable("studentId") Integer studentId) {
        return scoreClient.getAverageScoreByStudent(studentId);
    }

    @GetMapping("/course/{courseId}/average")
    public Double getAverageScoreByCourse(@PathVariable("courseId") Integer courseId) {
        return scoreClient.getAverageScoreByCourse(courseId);
    }

    @GetMapping("/student/{studentId}/report")
    public ScoreReport getScoreReport(@PathVariable("studentId") Integer studentId) {
        return scoreClient.getScoreReport(studentId);
    }
} 