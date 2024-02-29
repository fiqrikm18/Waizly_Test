package com.fiqrikm18.implemetation_test_1.domain.admin.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductResponse {

    @JsonProperty(index = 1)
    private UUID id;

    @JsonProperty(index = 2)
    private String name;

    @JsonProperty(index = 3)
    private String productSummary;

    @JsonProperty(index = 4)
    private int price;

    @JsonProperty(index = 5)
    private int discountPrice;

    @JsonProperty(index = 6)
    private LocalDateTime createdAt;

    @JsonProperty(index = 7)
    private LocalDateTime updatedAt;

    @JsonProperty(index = 8)
    private LocalDateTime deletedAt;

    public ProductResponse(UUID id, String name, String productSummary, int price, int discountPrice, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.name = name;
        this.productSummary = productSummary;
        this.price = price;
        this.discountPrice = discountPrice;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public ProductResponse() { }

    public static ProductResponse fromProduct(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getProductSummary(), product.getPrice(),
                product.getDiscountPrice(), product.getCreatedAt(), product.getUpdatedAt(), product.getDeletedAt());
    }
    public static List<ProductResponse> fromListProduct(List<Product> products) {
        List<ProductResponse> productResponses = new ArrayList<>();

        for (Product productData: products) {
            productResponses.add(new ProductResponse(productData.getId(), productData.getName(),
                    productData.getProductSummary(), productData.getPrice(),
                    productData.getDiscountPrice(), productData.getCreatedAt(),
                    productData.getUpdatedAt(), productData.getDeletedAt()));
        }

        return productResponses;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
}
