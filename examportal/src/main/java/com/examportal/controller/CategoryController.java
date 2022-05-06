package com.examportal.controller;

import com.examportal.model.exam.Category;
import com.examportal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //addCategory
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category category1 = this.categoryService.addCategory(category);
        return  ResponseEntity.ok(category1);
    }

    //getcategory
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId){
        return  this.categoryService.getCategory(categoryId);
    }

    //get all category
    @GetMapping("/")
    public ResponseEntity<?> getCategories(){
        return  ResponseEntity.ok(this.categoryService.getCategories());
    }

    @PutMapping("/")
    public  Category updateCategory(@RequestBody Category category){
        return  this.categoryService.updateCategory(category);
    }

    //delete
    @DeleteMapping("/{categoryId}")
    public  void deleteCategory(@PathVariable("categoryId") Long categoryId){
        this.categoryService.deleteCategory(categoryId);
    }




}
