package com.example.demo2.infrastructure.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para respuestas de error estándar de la API")
public class ErrorResponseDto {

    @Schema(description = "Código de estado HTTP", example = "404")
    private Integer status;

    @Schema(description = "Mensaje de error descriptivo", example = "Producto no encontrado")
    private String message;

    @Schema(description = "Mensaje de error detallado", example = "No se encontró un producto con el ID: 123")
    private String details;

    @Schema(description = "Timestamp del error", example = "2024-11-03T15:30:00")
    private LocalDateTime timestamp;

    @Schema(description = "Ruta donde ocurrió el error", example = "/inventory-products/123")
    private String path;
}
