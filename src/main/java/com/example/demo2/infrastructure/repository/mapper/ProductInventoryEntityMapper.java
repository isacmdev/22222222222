package com.example.demo2.infrastructure.repository.mapper;

import com.example.demo2.domain.entity.ProductInventory;
import com.example.demo2.infrastructure.repository.entity.ProductInventoryEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductInventoryEntityMapper {

    private ProductInventoryEntityMapper() {}

    public static ProductInventoryEntity toEntity(ProductInventory domain) {
        if (domain == null) return null;

        String images = (domain.getImages() != null && !domain.getImages().isEmpty())
                ? String.join(",", domain.getImages())
                : "";

        return ProductInventoryEntity.builder()
                .id(domain.getId())
                .internalCode(domain.getInternalCode())
                .name(domain.getName())
                .category(domain.getCategory())
                .technicalDescription(domain.getTechnicalDescription())
                .images(images)
                .stock(domain.getStock())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }

    public static ProductInventory toDomain(ProductInventoryEntity entity) {
        if (entity == null) return null;

        List<String> images = (entity.getImages() != null && !entity.getImages().isBlank())
                ? Arrays.stream(entity.getImages().split(","))
                .map(String::trim)
                .toList()
                : Collections.emptyList();

        return ProductInventory.builder()
                .id(entity.getId())
                .internalCode(entity.getInternalCode())
                .name(entity.getName())
                .category(entity.getCategory())
                .technicalDescription(entity.getTechnicalDescription())
                .images(images)
                .stock(entity.getStock())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
