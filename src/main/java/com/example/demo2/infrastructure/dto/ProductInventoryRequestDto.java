package com.example.demo2.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO para la creación o actualización de productos en el inventario")
public class ProductInventoryRequestDto {

    @JsonProperty("name")
    @Schema(description = "Nombre del producto", example = "Monitor LED 24 pulgadas", required = true)
    private String name;

    @JsonProperty("category")
    @Schema(description = "Categoría del producto", example = "Electrónicos", required = true)
    private String category;

    @JsonProperty("technicalDescription")
    @Schema(description = "Descripción técnica detallada del producto",
            example = "Monitor LED de 24 pulgadas con resolución Full HD 1920x1080")
    private String technicalDescription;

    @JsonProperty("images")
    @Schema(description = "Lista de URLs de imágenes del producto",
            example = "[\"https://example.com/image1.jpg\", \"https://example.com/image2.jpg\"]")
    private List<String> images;

    @JsonProperty("stock")
    @Schema(description = "Cantidad inicial de stock", example = "50", required = true, minimum = "0")
    private Integer stock;
}
