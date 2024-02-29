package com.fiqrikm18.implemetation_test_1.domain.admin.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderAdminRepository extends JpaRepository<Order, UUID> { }
