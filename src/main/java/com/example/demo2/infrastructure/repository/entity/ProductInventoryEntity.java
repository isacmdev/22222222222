package com.example.demo2.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_inventory")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductInventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "internal_code", nullable = false, unique = true)
    private String internalCode;

    @Column(nullable = false)
    private String name;

    private String category;

    @Column(name = "technical_description", columnDefinition = "TEXT")
    private String technicalDescription;

    @Column(name = "images", columnDefinition = "TEXT")
    private String images;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
