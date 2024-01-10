package org.sid.orderservice.model;

import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    @Transient
    private Product product;
    private double price;
    private int quantity;
}
