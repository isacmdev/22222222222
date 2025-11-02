package com.example.demo2.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInventoryRequestDto {
    private String name;
    private String category;
    private String technicalDescription;
    private Boolean available;
    private List<String> images;
}
