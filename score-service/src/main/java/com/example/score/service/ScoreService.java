package com.example.score.service;

import java.util.List;
import java.util.DoubleSummaryStatistics;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import com.example.score.mapper.ScoreMapper;
import com.example.score.model.Score;
import com.example.score.model.ScoreReport;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreMapper scoreMapper;

    public List<Score> findAll() {
        return scoreMapper.findAll();
    }

    public Score findById(Integer id) {
        return scoreMapper.findById(id);
    }

    public List<Score> findByStudentId(Integer studentId) {
        return scoreMapper.findByStudentId(studentId);
    }

    public List<Score> findByCourseId(Integer courseId) {
        return scoreMapper.findByCourseId(courseId);
    }

    @Transactional
    public void addScore(Score score) {
        scoreMapper.insert(score);
    }

    @Transactional
    public void updateScore(Score score) {
        scoreMapper.update(score);
    }

    @Transactional
    public void deleteScore(Integer id) {
        scoreMapper.deleteById(id);
    }

    public Double getAverageScoreByStudentId(Integer studentId) {
        return scoreMapper.getAverageScoreByStudentId(studentId);
    }

    public Double getAverageScoreByCourseId(Integer courseId) {
        return scoreMapper.getAverageScoreByCourseId(courseId);
    }

    public ScoreReport generateScoreReport(Integer studentId) {
        List<Score> scores = scoreMapper.findStudentScoresWithDetails(studentId);
        if (scores.isEmpty()) {
            return null;
        }

        ScoreReport report = new ScoreReport();
        report.setStudentId(studentId);
        report.setStudentName(scores.get(0).getStudentName());
        report.setScores(scores);
        report.setCourseCount(scores.size());

        DoubleSummaryStatistics stats = scores.stream()
            .mapToDouble(Score::getGrade)
            .summaryStatistics();

        report.setAverageScore(stats.getAverage());
        report.setTotalScore(stats.getSum());
        report.setHighestScore(stats.getMax());
        report.setLowestScore(stats.getMin());

        return report;
    }
} 