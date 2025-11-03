package com.example.demo2.infrastructure.repository.adapter;

import com.example.demo2.domain.entity.ProductInventory;
import com.example.demo2.domain.port.out.ProductInventoryInterfacePortOut;
import com.example.demo2.infrastructure.repository.entity.ProductInventoryEntity;
import com.example.demo2.infrastructure.repository.mapper.ProductInventoryEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ProductInventoryRepository implements ProductInventoryInterfacePortOut {

    private final ProductInventoryJpa productInventoryJpa;

    @Override
    public ProductInventory saveProduct(ProductInventory product) {
        if (product.getInternalCode() == null) {
            product.setInternalCode("PRD-" + System.currentTimeMillis());
        }

        product.setCreatedAt(LocalDateTime.now());

        ProductInventoryEntity entity = ProductInventoryEntityMapper.toEntity(product);
        ProductInventoryEntity saved = productInventoryJpa.save(entity);

        return ProductInventoryEntityMapper.toDomain(saved);
    }

    @Override
    public ProductInventory findProductById(Long id) {
        Optional<ProductInventoryEntity> entity = productInventoryJpa.findById(id);
        return entity.map(ProductInventoryEntityMapper::toDomain).orElse(null);
    }

    @Override
    public List<ProductInventory> findAllProducts() {
        return productInventoryJpa.findAll()
                .stream()
                .map(ProductInventoryEntityMapper::toDomain)
                .toList();
    }

    @Override
    public ProductInventory updateProduct(Long id, ProductInventory product) {
        Optional<ProductInventoryEntity> existingOpt = productInventoryJpa.findById(id);
        if (existingOpt.isEmpty()) return null;

        ProductInventoryEntity existing = existingOpt.get();
        existing.setName(product.getName());
        existing.setCategory(product.getCategory());
        existing.setTechnicalDescription(product.getTechnicalDescription());
        existing.setImages(product.getImages().toString());
        existing.setUpdatedAt(LocalDateTime.now());

        ProductInventoryEntity updated = productInventoryJpa.save(existing);
        return ProductInventoryEntityMapper.toDomain(updated);
    }

    @Override
    public void deleteProduct(Long id) {
        if (productInventoryJpa.existsById(id)) {
            productInventoryJpa.deleteById(id);
        }
    }

    @Override
    public ProductInventory addStock(Long id, int quantity) {
        Optional<ProductInventoryEntity> existingOpt = productInventoryJpa.findById(id);
        if (existingOpt.isEmpty()) return null;

        ProductInventoryEntity existing = existingOpt.get();
        existing.setStock(existing.getStock() + quantity);
        existing.setUpdatedAt(LocalDateTime.now());

        ProductInventoryEntity updated = productInventoryJpa.save(existing);
        return ProductInventoryEntityMapper.toDomain(updated);
    }

    @Override
    public ProductInventory removeStock(Long id, int quantity) {
        Optional<ProductInventoryEntity> existingOpt = productInventoryJpa.findById(id);
        if (existingOpt.isEmpty()) return null;

        ProductInventoryEntity existing = existingOpt.get();
        existing.setStock(existing.getStock() - quantity);
        existing.setUpdatedAt(LocalDateTime.now());

        ProductInventoryEntity updated = productInventoryJpa.save(existing);
        return ProductInventoryEntityMapper.toDomain(updated);
    }

    @Override
    public ProductInventory findByInternalCode(String internalCode) {
        Optional<ProductInventoryEntity> entity = productInventoryJpa.findByInternalCode(internalCode);
        return entity.map(ProductInventoryEntityMapper::toDomain).orElse(null);
    }
}
