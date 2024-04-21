package com.proj.website.service;

import com.proj.website.model.Product;
import com.proj.website.model.Category;
import com.proj.website.model.dto.request.ProductRequest;
import com.proj.website.model.dto.response.ProductResponse;
import com.proj.website.repository.CategoryRepository;
import com.proj.website.repository.ProductRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());

        Category category = categoryRepository.getReferenceById(productRequest.getCategoryId());
        product.setCategory(category);
        return ProductResponse.fromProduct(productRepository.save(product));
    }
    @Transactional
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductResponse::fromProduct)
                .collect(Collectors.toList());
    }
    @Transactional
    public ProductResponse getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.map(ProductResponse::fromProduct).orElse(null);
    }

    @Transactional
    public void removeProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(productRequest.getName());
            product.setPrice(productRequest.getPrice());

            Category category = categoryRepository.getReferenceById(productRequest.getCategoryId());
            product.setCategory(category);
            return ProductResponse.fromProduct(productRepository.save(product));
        }
        return null;
    }
}
