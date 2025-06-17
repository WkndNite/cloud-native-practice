package com.example.scoreclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.scoreclient.model.Score;
import com.example.scoreclient.model.ScoreReport;

@FeignClient(name = "score-service", fallback = ScoreClientFallback.class)
public interface ScoreClient {
    @GetMapping("/scores")
    List<Score> getAllScores();

    @GetMapping("/scores/{id}")
    Score getScoreById(@PathVariable("id") Integer id);

    @GetMapping("/scores/student/{studentId}")
    List<Score> getScoresByStudent(@PathVariable("studentId") Integer studentId);

    @GetMapping("/scores/course/{courseId}")
    List<Score> getScoresByCourse(@PathVariable("courseId") Integer courseId);

    @PostMapping("/scores")
    void addScore(@RequestBody Score score);

    @PutMapping("/scores/{id}")
    void updateScore(@PathVariable("id") Integer id, @RequestBody Score score);

    @DeleteMapping("/scores/{id}")
    void deleteScore(@PathVariable("id") Integer id);

    @GetMapping("/scores/student/{studentId}/average")
    Double getAverageScoreByStudent(@PathVariable("studentId") Integer studentId);

    @GetMapping("/scores/course/{courseId}/average")
    Double getAverageScoreByCourse(@PathVariable("courseId") Integer courseId);

    @GetMapping("/scores/student/{studentId}/report")
    ScoreReport getScoreReport(@PathVariable("studentId") Integer studentId);
} 