package com.fiqrikm18.implemetation_test_1.domain.order;

import com.fiqrikm18.implemetation_test_1.domain.admin.order.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusRequest {

    private OrderStatus status;

}
