package com.gabriellaureano.ecommerce.controllers;

import com.gabriellaureano.ecommerce.domain.Product;
import com.gabriellaureano.ecommerce.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> listar(){
        return productRepository.findAll();
    }

    @PostMapping
    public Product criar(@RequestBody Product product){
        return productRepository.save(product);
    }
}
