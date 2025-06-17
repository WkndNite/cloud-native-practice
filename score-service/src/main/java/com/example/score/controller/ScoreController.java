package com.example.score.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.example.score.model.Score;
import com.example.score.model.ScoreReport;
import com.example.score.service.ScoreService;

@RestController
@RequestMapping("/scores")
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;

    @GetMapping
    public List<Score> getAllScores() {
        return scoreService.findAll();
    }

    @GetMapping("/{id}")
    public Score getScoreById(@PathVariable Integer id) {
        return scoreService.findById(id);
    }

    @GetMapping("/student/{studentId}")
    public List<Score> getScoresByStudent(@PathVariable Integer studentId) {
        return scoreService.findByStudentId(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<Score> getScoresByCourse(@PathVariable Integer courseId) {
        return scoreService.findByCourseId(courseId);
    }

    @PostMapping
    public void addScore(@RequestBody Score score) {
        scoreService.addScore(score);
    }

    @PutMapping("/{id}")
    public void updateScore(@PathVariable Integer id, @RequestBody Score score) {
        score.setEnrollmentId(id);
        scoreService.updateScore(score);
    }

    @DeleteMapping("/{id}")
    public void deleteScore(@PathVariable Integer id) {
        scoreService.deleteScore(id);
    }

    @GetMapping("/student/{studentId}/average")
    public Double getAverageScoreByStudent(@PathVariable Integer studentId) {
        return scoreService.getAverageScoreByStudentId(studentId);
    }

    @GetMapping("/course/{courseId}/average")
    public Double getAverageScoreByCourse(@PathVariable Integer courseId) {
        return scoreService.getAverageScoreByCourseId(courseId);
    }

    @GetMapping("/student/{studentId}/report")
    public ScoreReport getScoreReport(@PathVariable Integer studentId) {
        return scoreService.generateScoreReport(studentId);
    }
} 