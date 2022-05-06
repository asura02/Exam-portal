package com.examportal.service.impl;

import com.examportal.model.exam.Category;
import com.examportal.model.exam.Quiz;
import com.examportal.repo.QuizRepo;
import com.examportal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepo.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepo.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(this.quizRepo.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return this.quizRepo.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {
        System.out.println("----------------------------------------------------------------------------------------------------------"+quizId);
        this.quizRepo.deleteById(quizId);


    }

    @Override
    public List<Quiz> getQuizzesOfCategory(Category category) {
        return this.quizRepo.findByCategory(category);
    }
}
