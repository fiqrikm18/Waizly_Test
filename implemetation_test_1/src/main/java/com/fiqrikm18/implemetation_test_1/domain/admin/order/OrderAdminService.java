package com.fiqrikm18.implemetation_test_1.domain.admin.order;

import com.fiqrikm18.implemetation_test_1.domain.admin.order_item.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderAdminService {

    @Autowired
    private OrderItemRepository orderItemRepository;

}
