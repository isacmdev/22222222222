package com.example.demo2.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryStockRespopnseDto {
    private Long id;
    private String internalCode;
    private Integer stock;
}
