package shop.gongdal.service;

import shop.gongdal.model.Product;
import shop.gongdal.model.ProductDate;
import shop.gongdal.model.ProductDetail;
import shop.gongdal.payload.ProductRequest;
import shop.gongdal.repository.productDate.ProductDateRepository;
import shop.gongdal.repository.productDetail.ProductDetailRepository;
import shop.gongdal.repository.product.ProductRepository;
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


    public List<Product> getProductByCondition(ProductRequest productRequest){

        String objectManagementNum = productRequest.getObjectManagementNum();
        String objectName = productRequest.getObjectName();
        Long appraisedPriceStart =productRequest.getAppraisedPriceStart();
        Long appraisedPriceEnd = productRequest.getAppraisedPriceEnd();
        Long bidBeginDateTime = productRequest.getBidBeginDateTime();
        Long bidCloseDateTime = productRequest.getBidCloseDateTime();
        String manufacturer = productRequest.getManufacturer();
        String model = productRequest.getModel();
        String transmission = productRequest.getTransmission();
        String fuelType = productRequest.getFuelType();
        Long yearAndMonthStart = productRequest.getYearAndMonthStart();
        Long yearAndMonthEnd = productRequest.getYearAndMonthEnd();
        Long displacementStart = productRequest.getDisplacementStart();
        Long displacementEnd = productRequest.getDisplacementEnd();
        Long distanceDrivenStart = productRequest.getDistanceDrivenStart();
        Long distanceDrivenEnd = productRequest.getDistanceDrivenEnd();

        List<Product> productList = productRepository.findByCarCondition(objectManagementNum,
                objectName,
                appraisedPriceStart,
                appraisedPriceEnd,
                bidBeginDateTime,
                bidCloseDateTime,
                manufacturer,
                model,
                transmission,
                fuelType,
                yearAndMonthStart,
                yearAndMonthEnd,
                displacementStart,
                displacementEnd,
                distanceDrivenStart,
                distanceDrivenEnd);

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
