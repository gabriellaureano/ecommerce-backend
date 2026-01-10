package com.gabriellaureano.ecommerce.controllers;

import com.gabriellaureano.ecommerce.domain.Product;
import com.gabriellaureano.ecommerce.repositories.ProductRepository;
import com.gabriellaureano.ecommerce.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> listar(){
        return productService.buscarProdutos();
    }

    @PostMapping
    public Product criar(@RequestBody Product product){
        return productService.criarProduto(product);
    }
}
