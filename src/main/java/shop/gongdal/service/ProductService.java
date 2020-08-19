package shop.gongdal.service;

import shop.gongdal.model.Product;
import shop.gongdal.model.ProductDate;
import shop.gongdal.model.ProductDetail;
import shop.gongdal.repository.ProductDateRepository;
import shop.gongdal.repository.ProductDetailRepository;
import shop.gongdal.repository.ProductRepository;
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
    public ProductService(ProductRepository productRepository,
                          ProductDetailRepository productDetailRepository,
                          ProductDateRepository productDateRepository) {
        this.productRepository = productRepository;
        this.productDetailRepository = productDetailRepository;
        this.productDateRepository = productDateRepository;
    }

    public Product getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) return null;
        return product.get();
    }


    public Page<Product> getProducts(int pageNum) {
        return productRepository.findAll(PageRequest.of(pageNum, pageSize));
    }

    public Product getProductByObjectManagementNum(String ObjectManagementNum) {
        Optional<Product> product = productRepository.findByObjectManagementNum(ObjectManagementNum);
        if (!product.isPresent()) return null;
        return product.get();
    }

    public Product getProductById(Long Id) {
        Optional<Product> product = productRepository.findById(Id);
        if (!product.isPresent()) return null;
        return product.get();
    }


    public List<Product> getProductsLikeObjectName(String ObjectName) {
        return productRepository.findByObjectNameLike("%" + ObjectName + "%");
    }

    public Product getProductWithDetailDate(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent()) return null;

        Product product = optionalProduct.get();

        Optional<ProductDetail> optionalProductDetail = productDetailRepository.findById(productId);

        List<ProductDate> productDateList = productDateRepository.findByProduct(product);

        product.setProductDetail(optionalProductDetail.get());
        product.setProductDate(productDateList);

        return product;
    }
}
