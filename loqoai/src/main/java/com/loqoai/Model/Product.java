package com.loqoai.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id  // Specifies the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indicates that the primary key is auto-generated
    private Integer id;            // Unique identifier for the product
    private String name;           // Name of the product
    private String category;      // Category to which the product belongs
    private double price;         // Price of the product
    private boolean inStock;      // Indicates whether the product is in stock
    private double rating;        // Rating of the product (e.g., from 1 to 10)
    @Temporal(TemporalType.TIMESTAMP)    // Specifies that the date should be stored with both date and time
    private Date createdAt;        // Timestamp indicating when the product was created


    @PrePersist  // This method is called before the entity is persisted
    protected void onCreate() {
        this.createdAt = new Date();  // Set the createdAt field to the current date and time
        System.out.println("Setting createdAt: " + this.createdAt);
    }

}
