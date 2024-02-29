package com.fiqrikm18.implemetation_test_1.domain.order;

import com.fiqrikm18.implemetation_test_1.domain.admin.order.Order;
import com.fiqrikm18.implemetation_test_1.domain.admin.order.OrderStatus;
import com.fiqrikm18.implemetation_test_1.domain.admin.order_item.OrderItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponse {

    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private OrderStatus status;
    private int tax;
    private int subTotal;
    private int total;

    public static OrderResponse fromOrder(Order order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setCreatedAt(order.getCreatedAt());
        response.setUpdatedAt(order.getUpdatedAt());
        response.setDeletedAt(order.getDeletedAt());
        response.setStatus(order.getOrderStatus());
        response.setTax(order.getTax());
        response.setTotal(order.getTotal());
        response.setTax(order.getTotal() - order.getAdminFee() - order.getTax());

        return response;
    }

    public static List<OrderResponse> fromListOrder(List<Order> orders) {
        List<OrderResponse> response = new ArrayList<>();

        for (Order order: orders) {
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setId(order.getId());
            orderResponse.setCreatedAt(order.getCreatedAt());
            orderResponse.setUpdatedAt(order.getUpdatedAt());
            orderResponse.setDeletedAt(order.getDeletedAt());
            orderResponse.setStatus(order.getOrderStatus());
            orderResponse.setTax(order.getTax());
            orderResponse.setTotal(order.getTotal());
            orderResponse.setTax(order.getTotal() - order.getAdminFee() - order.getTax());

            response.add(orderResponse);
        }

        return response;
    }

}
