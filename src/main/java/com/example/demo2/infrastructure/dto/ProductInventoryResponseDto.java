package com.example.demo2.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductInventoryResponseDto {
    private Long id;
    private String internalCode;
    private String name;
    private String category;
    private String technicalDescription;
    private Boolean available;
    private List<String> images;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
