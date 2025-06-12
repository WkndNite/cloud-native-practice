package com.example.score.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.score.model.Score;

@Mapper
public interface ScoreMapper {
    List<Score> findAll();
    
    Score findById(Integer id);
    
    List<Score> findByStudentId(Integer studentId);
    
    List<Score> findByCourseName(String courseName);
    
    void insert(Score score);
    
    void update(Score score);
    
    void deleteById(Integer id);
    
    Double getAverageScoreByStudentId(Integer studentId);
    
    Double getAverageScoreByCourseName(String courseName);
} 