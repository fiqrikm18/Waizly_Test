package com.fiqrikm18.implemetation_test_1.domain.admin.order_item;

import com.fiqrikm18.implemetation_test_1.domain.admin.order.Order;
import com.fiqrikm18.implemetation_test_1.domain.admin.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "order_items")
@SQLRestriction("deleted_at IS NULL")
@SQLDelete(sql = "UPDATE product_orders SET deleted_at = NOW() WHERE id=?")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "created_at")
    @CreatedDate
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @JoinColumn(name = "order_id")
    @ManyToOne
    private Order order;

    @Column(name = "price")
    private int price;

    @Column(name = "qty")
    private int qty;

    @ManyToOne
    private Product product;

    public OrderItem(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, Order order, int qty) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.order = order;
        this.qty = qty;
    }

    public OrderItem() {
    }

}
