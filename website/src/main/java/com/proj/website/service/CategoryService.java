package com.proj.website.service;

import com.proj.website.model.Category;
import com.proj.website.model.dto.request.CategoryRequest;
import com.proj.website.model.dto.response.CategoryResponse;
import com.proj.website.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    public CategoryResponse updateCategory(Long categoryId, CategoryRequest categoryRequest) {
        Category category = categoryRepository.findById(Math.toIntExact(categoryId))
                .orElseThrow(() -> new RuntimeException("Category not found")); // You can replace RuntimeException with a more specific exception
        category.setName(categoryRequest.getName());
        return CategoryResponse.fromCategory(categoryRepository.save(category));
    }

    @Transactional
    public CategoryResponse getCategory(Long categoryId) {
        Category category = categoryRepository.findById(Math.toIntExact(categoryId))
                .orElseThrow(() -> new RuntimeException("Category not found")); // You can replace RuntimeException with a more specific exception
        return CategoryResponse.fromCategory(category);
    }

    @Transactional
    public void removeCategory(Long id) {
        categoryRepository.deleteById(Math.toIntExact(id));
    }
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryResponse::fromCategory)
                .collect(Collectors.toList());
    }

}
