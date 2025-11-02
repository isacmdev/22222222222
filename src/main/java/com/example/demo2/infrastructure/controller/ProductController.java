package com.example.demo2.infrastructure.controller;

import com.example.demo2.domain.entity.ProductInventory;
import com.example.demo2.domain.port.in.ProductInventoryInterfacePortIn;
import com.example.demo2.infrastructure.dto.ProductInventoryRequestDto;
import com.example.demo2.infrastructure.dto.ProductInventoryResponseDto;
import com.example.demo2.infrastructure.dto.StockUpdateRequestDto;
import com.example.demo2.infrastructure.mapper.ProductInventoryMapperDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory-products")
public class ProductController {

    private final ProductInventoryInterfacePortIn productService;

    @PostMapping
    public ResponseEntity<ProductInventoryResponseDto> create(@RequestBody ProductInventoryRequestDto requestDto) {
        ProductInventory product = ProductInventoryMapperDto.toDomain(requestDto);
        ProductInventory created = productService.createProduct(product);
        return ResponseEntity.ok(ProductInventoryMapperDto.toResponse(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductInventoryResponseDto> update(
            @PathVariable Long id,
            @RequestBody ProductInventoryRequestDto requestDto
    ) {
        ProductInventory product = ProductInventoryMapperDto.toDomain(requestDto);
        ProductInventory updated = productService.updateProduct(id, product);
        return ResponseEntity.ok(ProductInventoryMapperDto.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductInventoryResponseDto> findById(@PathVariable Long id) {
        ProductInventory product = productService.getProductById(id);
        return ResponseEntity.ok(ProductInventoryMapperDto.toResponse(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductInventoryResponseDto>> findAll() {
        List<ProductInventory> products = productService.getAllProducts();
        return ResponseEntity.ok(ProductInventoryMapperDto.toResponseList(products));
    }

    @PatchMapping("/{id}/add-stock")
    public ResponseEntity<ProductInventoryResponseDto> addStock(
            @PathVariable Long id,
            @RequestBody StockUpdateRequestDto requestDto
    ) {
        ProductInventory updated = productService.addStock(id, requestDto.getQuantity());
        return ResponseEntity.ok(ProductInventoryMapperDto.toResponse(updated));
    }

    @PatchMapping("/{id}/remove-stock")
    public ResponseEntity<ProductInventoryResponseDto> removeStock(
            @PathVariable Long id,
            @RequestBody StockUpdateRequestDto requestDto
    ) {
        ProductInventory updated = productService.removeStock(id, requestDto.getQuantity());
        return ResponseEntity.ok(ProductInventoryMapperDto.toResponse(updated));
    }
}
