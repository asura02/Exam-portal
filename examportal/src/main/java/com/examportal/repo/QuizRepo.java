package com.examportal.repo;

import com.examportal.model.exam.Category;
import com.examportal.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepo extends JpaRepository<Quiz,Long> {
    public List<Quiz> findByCategory(Category category);
}
