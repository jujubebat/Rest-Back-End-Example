package com.jujubebat.service;

import com.jujubebat.model.Product;
import com.jujubebat.model.ProductDate;
import com.jujubebat.model.ProductDetail;
import com.jujubebat.repository.ProductDateRepository;
import com.jujubebat.repository.ProductDetailRepository;
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
    private final ProductDetailRepository productDetailRepository;
    private final ProductDateRepository productDateRepository;
    private final int pageSize = 10;

    @Autowired
    public  ProductService(ProductRepository productRepository,
                           ProductDetailRepository productDetailRepository,
                           ProductDateRepository productDateRepository){
        this.productRepository = productRepository;
        this.productDetailRepository = productDetailRepository;
        this.productDateRepository = productDateRepository;
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

    public Product getProductById(Long Id){
        Optional<Product> product = productRepository.findById(Id);
        if(!product.isPresent()) return null;
        return product.get();
    }

    public Product getProductByPublicAuctionNum(Long publicAuctionNum){
        Optional<Product> product = productRepository.findByPublicAuctionNum(publicAuctionNum);
        if(!product.isPresent()) return null;
        return product.get();
    }

    public List<Product> getProductsLikeObjectName(String ObjectName){
        return productRepository.findByObjectNameLike("%" + ObjectName + "%");
    }

    public Product getProductWithDetailDate(Long publicAuctionNum){
        Optional<Product> optionalProduct = productRepository.findByPublicAuctionNum(publicAuctionNum);

        if(!optionalProduct.isPresent()) return null;

        Product product = optionalProduct.get();

        Optional<ProductDetail> optionalProductDetail = productDetailRepository.findByPublicAuctionNum(publicAuctionNum);

        List<ProductDate> productDateList = productDateRepository.findByPublicAuctionNum(publicAuctionNum);

        product.setProductDetail(optionalProductDetail.get());
        product.setProductDate(productDateList);

        return product;

        /*
           Optional<Product> optionalProduct = productRepository.findByPublicAuctionNum(publicAuctionNum);

        if(!optionalProduct.isPresent()) return null;

        Product product = optionalProduct.get();

        Optional<ProductDetail> productDetail = productDetailRepository.(product.getId());
        List<ProductDate> productDate = productDateRepository.findById(product.getId());

        returnProduct.setProductDetail(productDetail.get());
        returnProduct.setProductDate(productDate.get());

        return returnProduct;


         */
    }
}
