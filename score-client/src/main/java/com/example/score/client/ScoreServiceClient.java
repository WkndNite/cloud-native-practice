package com.example.score.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.example.score.model.Score;
import com.example.score.model.ScoreReport;

@FeignClient(name = "score-service", fallback = ScoreServiceClientFallback.class)
public interface ScoreServiceClient {
    @GetMapping("/scores")
    List<Score> findAll();

    @GetMapping("/scores/{id}")
    Score findById(@PathVariable("id") Integer id);

    @GetMapping("/scores/student/{studentId}")
    List<Score> findByStudentId(@PathVariable("studentId") Integer studentId);

    @GetMapping("/scores/course/{courseName}")
    List<Score> findByCourseName(@PathVariable("courseName") String courseName);

    @PostMapping("/scores")
    void addScore(@RequestBody Score score);

    @PutMapping("/scores")
    void updateScore(@RequestBody Score score);

    @DeleteMapping("/scores/{id}")
    void deleteScore(@PathVariable("id") Integer id);

    @GetMapping("/scores/student/{studentId}/average")
    Double getAverageScoreByStudentId(@PathVariable("studentId") Integer studentId);

    @GetMapping("/scores/course/{courseName}/average")
    Double getAverageScoreByCourseName(@PathVariable("courseName") String courseName);

    @GetMapping("/scores/student/{studentId}/report")
    ScoreReport generateScoreReport(@PathVariable("studentId") Integer studentId);
} 