package com.jujubebat.service;

import com.jujubebat.model.Product;
import com.jujubebat.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final int pageSize = 10;

    @Autowired
    public  ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product getProduct(Long id){
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()) return null;
        return product.get();
    }

    public Page<Product> getProducts(int pageNum){
        return productRepository.findAll(PageRequest.of(pageNum,pageSize));
    }

    public Product getProductByObjectManagementNum(String ObjectManagementNum){
        Optional<Product> product = productRepository.findByObjectManagementNum(ObjectManagementNum);
        if(!product.isPresent()) return null;
        return product.get();
    }

    public List<Product> getProductsLikeObjectName(String ObjectName){
        return productRepository.findByObjectNameLike("%" + ObjectName + "%");
    }
}
