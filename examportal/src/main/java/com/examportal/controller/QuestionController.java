package com.examportal.controller;

import com.examportal.model.exam.Question;
import com.examportal.model.exam.Quiz;
import com.examportal.service.QuestionService;
import com.examportal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    //add question
    @PostMapping("/")
    public ResponseEntity<Question> add(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //update
    //add question
    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    //get all quiz
    @GetMapping("/quiz/{qid}")
    public  ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid){
//        Quiz quiz = new Quiz();
//        quiz.setQid(qid);
//        Set<Question> questionOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
//        return  ResponseEntity.ok(questionOfQuiz);

        Quiz quiz = this.quizService.getQuiz(qid);
        Set<Question> questions = quiz.getQuestions();
        List list = new ArrayList<>(questions);
        if(list.size()>Integer.parseInt((quiz.getNumberOfQuestions()))){
            list = list.subList(0,Integer.parseInt((quiz.getNumberOfQuestions())));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/quiz/all/{qid}")
    public  ResponseEntity<?> getQuestionOfQuizAdmin(@PathVariable("qid") Long qid){
        Quiz quiz = new Quiz();
        quiz.setQid(qid);
        Set<Question> questionOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
        return  ResponseEntity.ok(questionOfQuiz);


    }



    //get Single question
    @GetMapping("/{questionId}")
    public  Question question(@PathVariable("questionId") Long questionId){
        return  this.questionService.getQuestion(questionId);
    }

    //delete question
    @DeleteMapping("/{questionId}")
    public  void delete(@PathVariable("questionId") Long questionId){
        this.questionService.deleteQuesion(questionId);
    }







}
