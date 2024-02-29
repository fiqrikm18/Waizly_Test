package com.fiqrikm18.implemetation_test_1.domain.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiqrikm18.implemetation_test_1.domain.admin.order_item.OrderItem;
import com.fiqrikm18.implemetation_test_1.domain.admin.product.Product;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderRequest {

    @JsonProperty(index = 1)
    private String productId;

    @JsonProperty(index = 2)
    private int qty;

}
