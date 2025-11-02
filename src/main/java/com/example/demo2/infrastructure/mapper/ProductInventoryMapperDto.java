package com.example.demo2.infrastructure.mapper;

import com.example.demo2.domain.entity.ProductInventory;
import com.example.demo2.infrastructure.dto.ProductInventoryRequestDto;
import com.example.demo2.infrastructure.dto.ProductInventoryResponseDto;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class ProductInventoryMapperDto {
    private ProductInventoryMapperDto() {}

    public static ProductInventory toDomain(ProductInventoryRequestDto dto) {
        if (dto == null) return null;

        return ProductInventory.builder()
                .name(dto.getName())
                .category(dto.getCategory())
                .technicalDescription(dto.getTechnicalDescription())
                .images(dto.getImages())
                .stock(dto.getStock())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static ProductInventoryResponseDto toResponse(ProductInventory entity) {
        if (entity == null) return null;

        return ProductInventoryResponseDto.builder()
                .id(entity.getId())
                .internalCode(entity.getInternalCode())
                .name(entity.getName())
                .category(entity.getCategory())
                .technicalDescription(entity.getTechnicalDescription())
                .images(entity.getImages())
                .stock(entity.getStock())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static List<ProductInventoryResponseDto> toResponseList(List<ProductInventory> entities) {
        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        }

        return entities.stream()
                .map(ProductInventoryMapperDto::toResponse)
                .toList();
    }
}
