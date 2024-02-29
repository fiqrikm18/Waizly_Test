package com.fiqrikm18.implemetation_test_1.domain.admin.order;

import com.fiqrikm18.implemetation_test_1.domain.admin.order_item.OrderItem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OrderAdminResponse {

    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private int orderId;
    private List<OrderItem> orderItem;

}
