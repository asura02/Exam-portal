package com.examportal.controller;

import com.examportal.model.exam.Category;
import com.examportal.model.exam.Quiz;
import com.examportal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    //add quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //update quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //get all quiz
    @GetMapping("/")
    public  ResponseEntity<?> quizzes(){
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    //get Single quiz
    @GetMapping("/{quizId}")
    public  Quiz quiz(@PathVariable("quizId") Long quizId){
        return  this.quizService.getQuiz(quizId);
    }

    //delete quiz
    @DeleteMapping("/{qid}")
    public  Long deletequiz(@PathVariable("qid") Long qid){
        this.quizService.deleteQuiz(qid);
        return  qid;
    }

    //getquizbycategory
    @GetMapping("/cquiz/{cid}")
    public List<Quiz> getQuizziesOfCategory(@PathVariable("cid") Long cid){
        Category category = new Category();
        category.setCid(cid);
        return  this.quizService.getQuizzesOfCategory(category);
    }



}
