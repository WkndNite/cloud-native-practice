package com.example.stats.service.impl;

import com.example.stats.mapper.StatsMapper;
import com.example.stats.model.CourseEnrollmentStats;
import com.example.stats.model.GradeDistribution;
import com.example.stats.model.StudentPerformance;
import com.example.stats.service.StatsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatsServiceImpl implements StatsService {

    private final StatsMapper statsMapper;

    public StatsServiceImpl(StatsMapper statsMapper) {
        this.statsMapper = statsMapper;
    }

    @Override
    public List<GradeDistribution> getGradeDistribution() {
        return statsMapper.getGradeDistribution();
    }

    @Override
    public List<GradeDistribution> getCourseGradeDistribution(Integer courseId) {
        return statsMapper.getCourseGradeDistribution(courseId);
    }

    @Override
    public List<CourseEnrollmentStats> getCourseEnrollmentStats() {
        return statsMapper.getCourseEnrollmentStats();
    }

    @Override
    public List<StudentPerformance> getStudentPerformance() {
        return statsMapper.getStudentPerformance();
    }

    @Override
    public StudentPerformance getStudentPerformanceById(Integer studentId) {
        return statsMapper.getStudentPerformanceById(studentId);
    }

    @Override
    public List<Map<String, Object>> getMajorAverageGrades() {
        return statsMapper.getMajorAverageGrades();
    }

    @Override
    public List<Map<String, Object>> getGradeLevelAverageGrades() {
        return statsMapper.getGradeLevelAverageGrades();
    }
}
