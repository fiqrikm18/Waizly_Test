package com.fiqrikm18.implemetation_test_1.domain.order;

import com.fiqrikm18.implemetation_test_1.domain.admin.order.Order;
import com.fiqrikm18.implemetation_test_1.domain.admin.order.OrderAdminRepository;
import com.fiqrikm18.implemetation_test_1.domain.admin.order.OrderStatus;
import com.fiqrikm18.implemetation_test_1.domain.admin.order_item.OrderItem;
import com.fiqrikm18.implemetation_test_1.domain.admin.order_item.OrderItemRepository;
import com.fiqrikm18.implemetation_test_1.domain.admin.product.Product;
import com.fiqrikm18.implemetation_test_1.domain.admin.product.ProductRepository;
import com.fiqrikm18.implemetation_test_1.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderAdminRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String id) {
        Optional<Order> orderData = orderRepository.findById(UUID.fromString((id)));
        if (orderData.isEmpty()) {
            throw new DataNotFoundException("Product data not found.");
        }

        return orderData.get();
    }

    public Order saveOrder(List<OrderRequest> request) {
        int subTotal = 0;
        Order order = orderRepository.save(Order.builder().orderStatus(OrderStatus.REQUESTED).build());

        for (OrderRequest orderRequest: request) {
            Optional<Product> productData = productRepository.findById(UUID.fromString(orderRequest.getProductId()));
            if (productData.isEmpty()) {
                throw new DataNotFoundException("Product data not found.");
            }

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setQty(orderRequest.getQty());
            orderItem.setProduct(productData.get());

            subTotal += (productData.get().getPrice() * orderRequest.getQty());

            orderItemRepository.save(orderItem);
        }

        order.setTax((int) (subTotal * 0.1));
        order.setAdminFee(2500);
        order.setTotal(((subTotal * 10) / 100) + 2500 + subTotal);
        order = orderRepository.save(order);

        return order;
    }

    public Order updateStatusOrder(OrderStatusRequest status, String id) {
        Optional<Order> orderData = orderRepository.findById(UUID.fromString((id)));
        if (orderData.isEmpty()) {
            throw new DataNotFoundException("Product data not found.");
        }

        Order order = orderData.get();
        order.setOrderStatus(status.getStatus());
        return orderRepository.save(order);
    }

}
