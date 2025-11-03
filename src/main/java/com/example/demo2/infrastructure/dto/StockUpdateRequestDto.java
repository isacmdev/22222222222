package com.example.demo2.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO para actualizar la cantidad de stock de un producto")
public class StockUpdateRequestDto {

    @Schema(description = "Cantidad a agregar o remover del stock",
            example = "10",
            required = true,
            minimum = "1")
    private Integer quantity;
}