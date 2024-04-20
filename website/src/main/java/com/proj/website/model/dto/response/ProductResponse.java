package com.proj.website.model.dto.response;

import com.proj.website.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private Integer price;
    private Long historyId;
    private Integer categoryId;

    public static ProductResponse fromProduct(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getHistory() == null ? null : product.getHistory().getId(),
            product.getCategory() == null ? null : product.getCategory().getId()
        );
    }
}
