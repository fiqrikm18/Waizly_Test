package com.fiqrikm18.implemetation_test_1.domain.admin.product;

import com.fiqrikm18.implemetation_test_1.exceptions.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product>  findAll() {
        return productRepository.findAll();
    }

    public Product findById(String id) {
        Optional<Product> productData = productRepository.findById(UUID.fromString(id));
        if (productData.isEmpty()) {
            throw new DataNotFoundException("Product data not found.");
        }

        return productData.get();
    }

    public Product save(ProductRequest request) {
        return productRepository.save(Product.fromProductRequest(request));
    }

    public void delete(String id) {
        Optional<Product> productData = productRepository.findById(UUID.fromString(id));
        if (productData.isEmpty()) {
            throw new DataNotFoundException("Product data not found.");
        }

        productRepository.delete(productData.get());
    }

    public Product update(ProductRequest request, String id) {
        Optional<Product> productData = productRepository.findById(UUID.fromString(id));
        if (productData.isEmpty()) {
            throw new DataNotFoundException("Product data not found.");
        }

        Product product = productData.get();
        product.setName(request.getName());
        product.setProductSummary(request.getProductSummary());
        product.setPrice(request.getPrice());
        product.setDiscountPrice(request.getDiscountPrice());
        return productRepository.save(product);
    }
}
