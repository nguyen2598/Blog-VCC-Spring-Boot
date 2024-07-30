package com.nguyen.blog.service;


import com.nguyen.blog.dto.request.CategoryCreationRequest;
import com.nguyen.blog.entity.Category;
import com.nguyen.blog.repository.CategoryRepository;
import com.nguyen.blog.utils.ApiResponseUtil;
import com.nguyen.blog.utils.CustomPageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;


    public ResponseEntity<Object> createCategory(CategoryCreationRequest request) {
        Category category =new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        return ApiResponseUtil.ok(categoryRepository.save(category));
    }
    public Category getCategory(String id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Category not found")// day la lambda
        );
    }
    public ResponseEntity<Object> getCategories() {
//        List<Category>
        List<Category> categories = categoryRepository.findAll();
        return ApiResponseUtil.ok(categories);
    }

    public ResponseEntity<Object> getCategoriesToPage(int page,int limit) {
//        List<Category>
        Pageable pageable = PageRequest.of(page-1, limit);
        Page<Category> categories = categoryRepository.findAll(pageable);
        System.out.println(categories);
        CustomPageData<Category> data=new CustomPageData<>(categories.getTotalElements(),categories.getContent());
        return ApiResponseUtil.ok(data);
    }
    public Category updateCategory(String id,CategoryCreationRequest request){
        Category category= getCategory(id);
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        return categoryRepository.save(category);
    }
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id+"");
    }

}
