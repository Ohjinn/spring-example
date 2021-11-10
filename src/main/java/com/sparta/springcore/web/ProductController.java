package com.sparta.springcore.web;

import com.sparta.springcore.domain.product.Product;
import com.sparta.springcore.web.dto.ProductMypriceRequestDto;
import com.sparta.springcore.service.ProductService;
import com.sparta.springcore.web.dto.ProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto productRequestDto){
        return productService.createProducts(productRequestDto);
    }

    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto){
        Product product = productService.updateProduct(id, requestDto);
        return product.getId();
    }
}
