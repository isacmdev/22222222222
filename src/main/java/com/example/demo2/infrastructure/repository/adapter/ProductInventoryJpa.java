package com.example.demo2.infrastructure.repository.adapter;

import com.example.demo2.infrastructure.repository.entity.ProductInventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInventoryJpa extends JpaRepository<ProductInventoryEntity, Long> {
}
