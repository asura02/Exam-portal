package com.examportal.service;

import com.examportal.model.exam.Question;
import com.examportal.model.exam.Quiz;

import java.util.Set;

public interface QuestionService {

    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public void deleteQuesion(Long questionId);
    public Set<Question> getQuestions();
    public  Question getQuestion(Long questionId);
    public  Set<Question> getQuestionOfQuiz(Quiz quiz);

}
