package shop.gongcar.service;

import shop.gongcar.payload.ProductRequest;
import shop.gongcar.model.Product;
import shop.gongcar.model.ProductDate;
import shop.gongcar.model.ProductDetail;
import shop.gongcar.repository.productDate.ProductDateRepository;
import shop.gongcar.repository.productDetail.ProductDetailRepository;
import shop.gongcar.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDetailRepository productDetailRepository;
    private final ProductDateRepository productDateRepository;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          ProductDetailRepository productDetailRepository,
                          ProductDateRepository productDateRepository) {
        this.productRepository = productRepository;
        this.productDetailRepository = productDetailRepository;
        this.productDateRepository = productDateRepository;
    }

    public List<Product> getProduct(Long pageStartNum){
        return productRepository.findAll(pageStartNum);
    }

    public List<Product> getProductByCondition(ProductRequest productRequest){

        List<Product> productList = productRepository.findByCarCondition(
                productRequest.getPageStartNum(),
                productRequest.getObjectManagementNum(),
                productRequest.getObjectName(),
                productRequest.getAppraisedPriceStart(),
                productRequest.getAppraisedPriceEnd(),
                productRequest.getBidBeginDateTime(),
                productRequest.getBidCloseDateTime(),
                productRequest.getManufacturer(),
                productRequest.getModel(),
                productRequest.getTransmission(),
                productRequest.getFuelType(),
                productRequest.getYearAndMonthStart(),
                productRequest.getYearAndMonthEnd(),
                productRequest.getDisplacementStart(),
                productRequest.getDistanceDrivenEnd(),
                productRequest.getDistanceDrivenStart(),
                productRequest.getDistanceDrivenEnd());

        return productList;
    }

    public Product getProductWithDetailDate(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent()) return null;

        Product product = optionalProduct.get();
        Optional<ProductDetail> optionalProductDetail = productDetailRepository.findByProduct(product);
        List<ProductDate> productDateList = productDateRepository.findByProduct(product);

        product.setProductDetail(optionalProductDetail.get());
        product.setProductDate(productDateList);

        return product;
    }

}
