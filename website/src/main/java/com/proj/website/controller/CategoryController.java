package com.proj.website.controller;

import com.proj.website.model.Category;
import com.proj.website.model.dto.request.CategoryRequest;
import com.proj.website.model.dto.response.CategoryResponse;
import com.proj.website.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public CategoryResponse createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
         return categoryService.addCategory(categoryRequest);
    }
}
