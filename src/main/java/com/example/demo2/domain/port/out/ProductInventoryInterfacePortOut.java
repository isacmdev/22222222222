package com.example.demo2.domain.port.out;

import com.example.demo2.domain.entity.ProductInventory;

public interface ProductInventoryInterfacePortOut {
    ProductInventory saveProduct(ProductInventory product);
    ProductInventory findProductById(Long id);
    ProductInventory findAllProducts();
    ProductInventory updateProduct(ProductInventory product);
    void deleteProduct(Long id);
}
