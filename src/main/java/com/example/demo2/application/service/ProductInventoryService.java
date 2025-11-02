package com.example.demo2.application.service;

import com.example.demo2.domain.entity.ProductInventory;
import com.example.demo2.domain.port.in.ProductInventoryInterfacePortIn;
import com.example.demo2.domain.port.out.ProductInventoryInterfacePortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductInventoryService implements ProductInventoryInterfacePortIn {
    private final ProductInventoryInterfacePortOut productInventoryInterfacePortOut;

    @Override
    public ProductInventory createProduct(ProductInventory product) {
        return productInventoryInterfacePortOut.saveProduct(product);
    }

    @Override
    public ProductInventory getProductById(Long id) {
        return productInventoryInterfacePortOut.findProductById(id);
    }

    @Override
    public List<ProductInventory> getAllProducts() {
        return productInventoryInterfacePortOut.findAllProducts();
    }

    @Override
    public ProductInventory updateProduct(Long id, ProductInventory product) {
        return productInventoryInterfacePortOut.updateProduct(id, product);
    }

    @Override
    public void deleteProduct(Long id) {
        productInventoryInterfacePortOut.deleteProduct(id);
    }

    @Override
    public ProductInventory addStock(Long id, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity to add must be greater than zero.");
        }
        return productInventoryInterfacePortOut.addStock(id, quantity);
    }

    @Override
    public ProductInventory removeStock(Long id, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity to remove must be greater than zero.");
        }
        return productInventoryInterfacePortOut.removeStock(id, quantity);
    }
}
