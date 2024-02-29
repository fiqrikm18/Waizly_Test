package com.fiqrikm18.implemetation_test_1.domain.admin.order;

import com.fiqrikm18.implemetation_test_1.domain.admin.order_item.OrderItem;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@SQLRestriction("deleted_at IS NULL")
@SQLDelete(sql = "UPDATE orders SET deleted_at = NOW() WHERE id=?")
public class Order {

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

    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Column(name = "tax")
    private int tax;

    @Column(name = "total")
    private int total;

    @Column(name = "adm_fee")
    private int adminFee;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItem;

//    @OneToOne(mappedBy = "order")
//    private String user;

}
