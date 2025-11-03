package com.example.demo2.infrastructure.repository.adapter;

import com.example.demo2.infrastructure.repository.entity.ProductInventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductInventoryJpa extends JpaRepository<ProductInventoryEntity, Long> {
    Optional<ProductInventoryEntity> findByInternalCode(String internalCode);
}
