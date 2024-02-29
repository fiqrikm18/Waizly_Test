package com.fiqrikm18.implemetation_test_1.domain.admin.order_item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderItemRepository extends  JpaRepository<OrderItem, UUID>{
}
