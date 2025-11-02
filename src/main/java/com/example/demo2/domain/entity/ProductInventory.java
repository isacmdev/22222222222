package com.example.demo2.domain.entity;

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
public class ProductInventory {
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
