package com.crio.grocery.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    Customer customer;

    @OneToMany
    List<OrderItem> orderItems = new ArrayList<>();

    @CreationTimestamp
    Instant orderDate;

    Double totalPrice;
}
