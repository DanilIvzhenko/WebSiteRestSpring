package com.proj.website.controller;

import com.proj.website.model.dto.request.ProductHistoryRequest;
import com.proj.website.model.dto.response.ProductHistoryResponse;
import com.proj.website.service.ProductHistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-history")
@RequiredArgsConstructor
public class ProductHistoryController {

    private final ProductHistoryService productHistoryService;

    @PostMapping
    public ProductHistoryResponse createProductHistory(@Valid @RequestBody ProductHistoryRequest historyRequest) {
        return productHistoryService.addProductHistory(historyRequest);
    }

    @PutMapping("/{historyId}")
    public ProductHistoryResponse updateProductHistory(@PathVariable Long historyId, @Valid @RequestBody ProductHistoryRequest historyRequest) {
        return productHistoryService.updateProductHistory(historyId, historyRequest);
    }

    @GetMapping("/{historyId}")
    public ProductHistoryResponse getProductHistory(@PathVariable Long historyId) {
        return productHistoryService.getProductHistory(historyId);
    }

    @DeleteMapping("/{id}")
    public void removeProductHistory(@PathVariable("id") Long id) {
        productHistoryService.removeProductHistory(id);
    }
}
