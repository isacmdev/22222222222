package com.example.demo2.infrastructure.controller;

import com.example.demo2.domain.port.in.ProductInventoryInterfacePortIn;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@AllArgsConstructor
@RequestMapping("/inventory-products")
public class ProductController {
    private final ProductInventoryInterfacePortIn productInterfacePortIn;

    @PostMapping("/create")
    public EntityResponse<> createProducts() {
}
