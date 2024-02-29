package com.fiqrikm18.implemetation_test_1.domain.admin.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public class ProductRequest {
    @JsonProperty(index = 1)
    @NotNull
    @NotBlank
    private String name;

    @JsonProperty(index = 2)
    @NotNull
    @NotBlank
    private String productSummary;

    @JsonProperty(index = 3)
    @NotNull
    private int price;

    @JsonProperty(index = 4, defaultValue = "0")
    @NotNull
    private int discountPrice;

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
