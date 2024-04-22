package com.proj.website.model.dto.response;

import com.proj.website.model.ProductHistory;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductHistoryResponse {
    private Long id;
    private ProductResponse product;
    private OffsetDateTime boughtAt;
    private OffsetDateTime refundedAt;

    public static ProductHistoryResponse fromProductHistory(ProductHistory history) {
        return new ProductHistoryResponse(
            history.getId(),
            ProductResponse.fromProduct(history.getProduct()),
            history.getBoughtAt(),
            history.getRefundedAt()
        );
    }
}
