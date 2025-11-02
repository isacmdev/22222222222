package com.example.demo2.domain.port.in;


import com.example.demo2.domain.entity.ProductInventory;

public interface ProductInventoryInterfacePortIn {
    ProductInventory createProduct(ProductInventory product);
    ProductInventory getProductById(Long id);
    ProductInventory getAllProducts();
    ProductInventory updateProduct(ProductInventory product);
    void deleteProduct(Long id);
}
