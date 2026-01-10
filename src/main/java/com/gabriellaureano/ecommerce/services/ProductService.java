package com.gabriellaureano.ecommerce.services;

import com.gabriellaureano.ecommerce.domain.Product;
import com.gabriellaureano.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product criarProduto(Product product){
        productRepository.save(product);
        return product;
    }

    public List<Product> buscarProdutos(){
        return productRepository.findAll();
    }
}
