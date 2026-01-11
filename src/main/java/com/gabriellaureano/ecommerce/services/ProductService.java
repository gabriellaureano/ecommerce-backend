package com.gabriellaureano.ecommerce.services;

import com.gabriellaureano.ecommerce.domain.Product;
import com.gabriellaureano.ecommerce.dto.ProductCreateDTO;
import com.gabriellaureano.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product criarProduto(ProductCreateDTO product){
        Product produto = new Product();

        produto.setNome(product.getNome());
        produto.setDescricao(product.getDescricao());
        produto.setEstoque(product.getEstoque());
        produto.setPreco(product.getPreco());

        return productRepository.save(produto);
    }

    public List<Product> buscarProdutos(){
        return productRepository.findAll();
    }
}
