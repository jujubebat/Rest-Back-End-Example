package shop.gongcar.service;

import shop.gongcar.model.ProductDetail;
import shop.gongcar.repository.productDetail.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductDetailService {

    private final ProductDetailRepository productDetailRepository;

    @Autowired
    public ProductDetailService(ProductDetailRepository productDetailRepository) {
        this.productDetailRepository = productDetailRepository;
    }

    public ProductDetail getProductDetail(Long id) {
        Optional<ProductDetail> productDetail = productDetailRepository.findById(id);
        if (!productDetail.isPresent()) return null;
        return productDetail.get();
    }
}
