package com.examportal.service.impl;

import com.examportal.model.exam.Category;
import com.examportal.repo.CategoryRepo;
import com.examportal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceimpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return  this.categoryRepo.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return  new LinkedHashSet<>(this.categoryRepo.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) {
        return this.categoryRepo.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long CategoryId) {
    this.categoryRepo.deleteById(CategoryId);
    }
}
