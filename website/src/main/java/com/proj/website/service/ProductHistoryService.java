package com.proj.website.service;

import com.proj.website.model.Product;
import com.proj.website.model.ProductHistory;
import com.proj.website.model.dto.request.ProductHistoryRequest;
import com.proj.website.model.dto.response.ProductHistoryResponse;
import com.proj.website.repository.ProductHistoryRepository;
import com.proj.website.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductHistoryService {

    private final ProductHistoryRepository productHistoryRepository;
    private final ProductRepository productRepository;

    @Transactional
    public ProductHistoryResponse addProductHistory(ProductHistoryRequest historyRequest) {
        ProductHistory history = new ProductHistory();
        Product product = productRepository.getReferenceById(historyRequest.getProductId());

        history.setProduct(product);
        history.setBoughtAt(historyRequest.getBoughtAt());
        return ProductHistoryResponse.fromProductHistory(productHistoryRepository.save(history));
    }

    @Transactional
    public ProductHistoryResponse updateProductHistory(Long historyId, ProductHistoryRequest historyRequest) {
        ProductHistory history = productHistoryRepository.getReferenceById(historyId);
        Product product = productRepository.getReferenceById(historyRequest.getProductId());

        history.setProduct(product);
        history.setBoughtAt(historyRequest.getBoughtAt());
        history.setRefundedAt(historyRequest.getRefundedAt());
        return ProductHistoryResponse.fromProductHistory(productHistoryRepository.save(history));
    }

    @Transactional
    public ProductHistoryResponse getProductHistory(Long historyId) {
        ProductHistory history = productHistoryRepository.getReferenceById(historyId);
        return ProductHistoryResponse.fromProductHistory(history);
    }

    @Transactional
    public void removeProductHistory(Long id) {
        productHistoryRepository.deleteById(id);
    }
}
