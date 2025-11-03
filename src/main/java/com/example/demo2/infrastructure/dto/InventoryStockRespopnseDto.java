package com.example.demo2.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO simplificado que retorna información básica de stock de un producto")
public class InventoryStockRespopnseDto {

    @Schema(description = "ID único del producto", example = "1")
    private Long id;

    @Schema(description = "Código interno del producto", example = "PROD-2024-001")
    private String internalCode;

    @Schema(description = "Cantidad actual en stock", example = "25")
    private Integer stock;
}
