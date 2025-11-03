package com.example.demo2.domain.port.out;

import com.example.demo2.domain.entity.ProductInventory;
import com.example.demo2.infrastructure.repository.entity.ProductInventoryEntity;

import java.util.List;

public interface ProductInventoryInterfacePortOut {
    ProductInventory saveProduct(ProductInventory product);
    ProductInventory findProductById(Long id);
    List<ProductInventory> findAllProducts();
    ProductInventory updateProduct(Long id, ProductInventory product);
    void deleteProduct(Long id);
    ProductInventory addStock(Long id, int quantity);
    ProductInventory removeStock(Long id, int quantity);
    ProductInventory findByInternalCode(String internalCode);
}
