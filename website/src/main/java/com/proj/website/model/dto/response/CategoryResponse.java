package com.proj.website.model.dto.response;

import com.proj.website.model.Category;
import com.proj.website.model.Product;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryResponse {
    private Integer id;
    private String name;
    private List<Long> productsIds;

    public static CategoryResponse fromCategory(Category category) {
        return new CategoryResponse(
            category.getId(),
            category.getName(),
            category.getProducts() == null
                ? null
                : category.getProducts().stream().map(Product::getId).toList()
        );
    }
}
