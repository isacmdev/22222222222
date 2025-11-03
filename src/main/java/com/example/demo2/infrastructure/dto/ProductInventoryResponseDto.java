package com.example.demo2.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "DTO de respuesta con la información completa del producto")
public class ProductInventoryResponseDto {

    @Schema(description = "ID único del producto", example = "1")
    private Long id;

    @Schema(description = "Código interno generado automáticamente", example = "PROD-2024-001")
    private String internalCode;

    @Schema(description = "Nombre del producto", example = "Monitor LED 24 pulgadas")
    private String name;

    @Schema(description = "Categoría del producto", example = "Electrónicos")
    private String category;

    @Schema(description = "Descripción técnica detallada",
            example = "Monitor LED de 24 pulgadas con resolución Full HD 1920x1080")
    private String technicalDescription;

    @Schema(description = "Lista de URLs de imágenes",
            example = "[\"https://example.com/image1.jpg\", \"https://example.com/image2.jpg\"]")
    private List<String> images;

    @Schema(description = "Cantidad actual en stock", example = "45")
    private Integer stock;

    @Schema(description = "Fecha y hora de creación", example = "2024-11-03T10:30:00")
    private LocalDateTime createdAt;

    @Schema(description = "Fecha y hora de última actualización", example = "2024-11-03T15:45:00")
    private LocalDateTime updatedAt;
}
