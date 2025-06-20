package com.example.stats.controller;

import com.example.stats.model.CourseEnrollmentStats;
import com.example.stats.model.GradeDistribution;
import com.example.stats.model.StudentPerformance;
import com.example.stats.service.StatsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stats")
public class StatsController {

    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/grade-distribution")
    public List<GradeDistribution> getGradeDistribution() {
        return statsService.getGradeDistribution();
    }

    @GetMapping("/course/{courseId}/grade-distribution")
    public List<GradeDistribution> getCourseGradeDistribution(@PathVariable Integer courseId) {
        return statsService.getCourseGradeDistribution(courseId);
    }

    @GetMapping("/course-enrollment")
    public List<CourseEnrollmentStats> getCourseEnrollmentStats() {
        return statsService.getCourseEnrollmentStats();
    }

    @GetMapping("/student-performance")
    public List<StudentPerformance> getStudentPerformance() {
        return statsService.getStudentPerformance();
    }

    @GetMapping("/student/{studentId}/performance")
    public StudentPerformance getStudentPerformanceById(@PathVariable Integer studentId) {
        return statsService.getStudentPerformanceById(studentId);
    }

    @GetMapping("/major-average-grades")
    public List<Map<String, Object>> getMajorAverageGrades() {
        return statsService.getMajorAverageGrades();
    }

    @GetMapping("/grade-level-average-grades")
    public List<Map<String, Object>> getGradeLevelAverageGrades() {
        return statsService.getGradeLevelAverageGrades();
    }
}
