package com.example.demo2.infrastructure.controller;

import com.example.demo2.domain.entity.ProductInventory;
import com.example.demo2.domain.port.in.ProductInventoryInterfacePortIn;
import com.example.demo2.infrastructure.dto.InventoryStockRespopnseDto;
import com.example.demo2.infrastructure.dto.ProductInventoryRequestDto;
import com.example.demo2.infrastructure.dto.ProductInventoryResponseDto;
import com.example.demo2.infrastructure.dto.StockUpdateRequestDto;
import com.example.demo2.infrastructure.exception.ErrorResponseDto;
import com.example.demo2.infrastructure.mapper.ProductInventoryMapperDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory-products")
@Tag(name = "Inventario de Productos", description = "API para la gestión del inventario de productos")
public class ProductController {

    private final ProductInventoryInterfacePortIn productService;

    @Operation(
            summary = "Crear un nuevo producto",
            description = "Crea un nuevo producto en el inventario con la información proporcionada"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto creado exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductInventoryResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @PostMapping
    public ResponseEntity<ProductInventoryResponseDto> create(@RequestBody ProductInventoryRequestDto requestDto) {
        ProductInventory product = ProductInventoryMapperDto.toDomain(requestDto);
        ProductInventory created = productService.createProduct(product);
        return ResponseEntity.ok(ProductInventoryMapperDto.toResponse(created));
    }

    @Operation(
            summary = "Actualizar un producto",
            description = "Actualiza la información completa de un producto existente en el inventario"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto actualizado exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductInventoryResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductInventoryResponseDto> update(
            @Parameter(description = "ID del producto a actualizar", required = true)
            @PathVariable Long id,
            @RequestBody ProductInventoryRequestDto requestDto
    ) {
        ProductInventory product = ProductInventoryMapperDto.toDomain(requestDto);
        ProductInventory updated = productService.updateProduct(id, product);
        return ResponseEntity.ok(ProductInventoryMapperDto.toResponse(updated));
    }

    @Operation(
            summary = "Eliminar un producto",
            description = "Elimina un producto del inventario de forma permanente"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Producto eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID del producto a eliminar", required = true)
            @PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Obtener producto por ID",
            description = "Busca y retorna un producto específico del inventario por su ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductInventoryResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductInventoryResponseDto> findById(
            @Parameter(description = "ID del producto a buscar", required = true)
            @PathVariable Long id) {
        ProductInventory product = productService.getProductById(id);
        return ResponseEntity.ok(ProductInventoryMapperDto.toResponse(product));
    }

    @Operation(
            summary = "Obtener todos los productos",
            description = "Retorna una lista completa de todos los productos en el inventario"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de productos obtenida exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductInventoryResponseDto.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<ProductInventoryResponseDto>> findAll() {
        List<ProductInventory> products = productService.getAllProducts();
        return ResponseEntity.ok(ProductInventoryMapperDto.toResponseList(products));
    }

    @Operation(
            summary = "Agregar stock a un producto",
            description = "Incrementa la cantidad de stock disponible para un producto específico"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Stock agregado exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductInventoryResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Cantidad inválida",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @PatchMapping("/{id}/add-stock")
    public ResponseEntity<ProductInventoryResponseDto> addStock(
            @Parameter(description = "ID del producto al que se agregará stock", required = true)
            @PathVariable Long id,
            @RequestBody StockUpdateRequestDto requestDto
    ) {
        ProductInventory updated = productService.addStock(id, requestDto.getQuantity());
        return ResponseEntity.ok(ProductInventoryMapperDto.toResponse(updated));
    }

    @Operation(
            summary = "Remover stock de un producto",
            description = "Reduce la cantidad de stock disponible para un producto específico"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Stock removido exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductInventoryResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Cantidad inválida o stock insuficiente",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @PatchMapping("/{id}/remove-stock")
    public ResponseEntity<ProductInventoryResponseDto> removeStock(
            @Parameter(description = "ID del producto del que se removerá stock", required = true)
            @PathVariable Long id,
            @RequestBody StockUpdateRequestDto requestDto
    ) {
        ProductInventory updated = productService.removeStock(id, requestDto.getQuantity());
        return ResponseEntity.ok(ProductInventoryMapperDto.toResponse(updated));
    }

    @Operation(
            summary = "Obtener producto por código interno",
            description = "Busca un producto específico utilizando su código interno y retorna información de stock"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = InventoryStockRespopnseDto.class))),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @GetMapping("/internal-code/{internalCode}")
    public ResponseEntity<InventoryStockRespopnseDto> findByInternalCode(
            @Parameter(description = "Código interno del producto a buscar", required = true)
            @PathVariable String internalCode) {
        ProductInventory product = productService.getByInternalCode(internalCode);
        return ResponseEntity.ok(ProductInventoryMapperDto.toInventoryResponseDto(product));
    }
}
