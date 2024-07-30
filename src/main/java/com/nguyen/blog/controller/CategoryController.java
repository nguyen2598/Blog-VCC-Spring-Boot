package com.nguyen.blog.controller;

import com.nguyen.blog.dto.request.CategoryCreationRequest;
import com.nguyen.blog.dto.request.LanguageCreationRequest;
import com.nguyen.blog.entity.Category;
import com.nguyen.blog.entity.Language;
import com.nguyen.blog.service.CategoryService;
import com.nguyen.blog.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @PostMapping("/create-category")
    ResponseEntity<Object> createCategory(@RequestBody CategoryCreationRequest request) {
       return categoryService.createCategory(request);
    }
    @GetMapping("")
    ResponseEntity<Object> getCategories(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit
            ) {
        if (page < 1) {
            page = 1;
        }
        return  categoryService.getCategoriesToPage(page,limit);
    }
    @GetMapping("/all")
    ResponseEntity<Object> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{categoryId}")
    Category getCategory(@PathVariable("categoryId") String categoryId) {
        return  categoryService.getCategory(categoryId);
    }


    @PutMapping("/edit-category/{categoryId}")
    Category updateCategory(@PathVariable String categoryId, @RequestBody CategoryCreationRequest request) {
        return categoryService.updateCategory(categoryId, request);
    }


    @DeleteMapping("/delete/{categoryId}")
    void deleteCategory(@PathVariable int categoryId) {
        categoryService.deleteCategory(categoryId);
    }

}
