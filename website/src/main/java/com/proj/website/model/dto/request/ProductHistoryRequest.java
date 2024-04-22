package com.proj.website.model.dto.request;

import java.time.OffsetDateTime;
import lombok.Data;
import lombok.NonNull;

@Data
public class ProductHistoryRequest {
    @NonNull
    private Long productId;
    @NonNull
    private OffsetDateTime boughtAt;
    private OffsetDateTime refundedAt;
}
