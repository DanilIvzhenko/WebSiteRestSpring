package com.proj.website.service;

import com.proj.website.model.Category;
import com.proj.website.model.dto.request.CategoryRequest;
import com.proj.website.model.dto.response.CategoryResponse;
import com.proj.website.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public CategoryResponse addCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        return CategoryResponse.fromCategory(categoryRepository.save(category));
    }
}
