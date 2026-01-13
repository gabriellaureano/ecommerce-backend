package com.gabriellaureano.ecommerce.controllers;

import com.gabriellaureano.ecommerce.domain.Product;
import com.gabriellaureano.ecommerce.dto.ProductCreateDTO;
import com.gabriellaureano.ecommerce.repositories.ProductRepository;
import com.gabriellaureano.ecommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // BUSCA TODOS OS PRODUTOS CRIADOS
    @GetMapping
    public List<Product> listar(){
        return productService.buscarProdutos();
    }

    // CRIA UM NOVO PRODUTO
    @PostMapping
    public Product criar(@RequestBody @Valid ProductCreateDTO product){
        return productService.criarProduto(product);
    }
}
