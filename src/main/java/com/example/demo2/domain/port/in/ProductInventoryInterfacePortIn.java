package com.example.demo2.domain.port.in;


import com.example.demo2.domain.entity.ProductInventory;

import java.util.List;

public interface ProductInventoryInterfacePortIn {
    ProductInventory createProduct(ProductInventory product);
    ProductInventory getProductById(Long id);
    List<ProductInventory> getAllProducts();
    ProductInventory updateProduct(Long id,ProductInventory product);
    void deleteProduct(Long id);
    ProductInventory addStock(Long id, int quantity);
    ProductInventory removeStock(Long id, int quantity);
}
