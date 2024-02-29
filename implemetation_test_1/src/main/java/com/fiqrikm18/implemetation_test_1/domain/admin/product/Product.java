package com.fiqrikm18.implemetation_test_1.domain.admin.product;

import com.fiqrikm18.implemetation_test_1.domain.admin.order_item.OrderItem;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "products")
@SQLRestriction("deleted_at IS NULL")
@SQLDelete(sql = "UPDATE products SET deleted_at = NOW() WHERE id=?")
public class Product {

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

    @Column(name = "name")
    private String name;

    @Column(name = "summary")
    private String productSummary;

    @Column(name = "price")
    private int price;

    @Column(name = "discount")
    private int discountPrice;

    @OneToMany
    private List<OrderItem> orderItem;

    public Product(String name, String productSummary, int price, int discountPrice) {
        this.name = name;
        this.productSummary = productSummary;
        this.price = price;
        this.discountPrice = discountPrice;
    }

    public Product() {}

    public static Product fromProductRequest(ProductRequest request) {
        return new Product(request.getName(), request.getProductSummary(), request.getPrice(), request.getDiscountPrice());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductSummary() {
        return productSummary;
    }

    public void setProductSummary(String productSummary) {
        this.productSummary = productSummary;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

}
