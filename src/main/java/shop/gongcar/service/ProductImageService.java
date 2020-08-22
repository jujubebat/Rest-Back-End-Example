package shop.gongcar.service;

import shop.gongcar.model.ProductImage;
import shop.gongcar.repository.productImage.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageService {

    private final ProductImageRepository productImageRepository;

    @Autowired
    public ProductImageService(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }

    public List<ProductImage> getProductImageByProductId(Long productId) {
        return productImageRepository.findByProductId(productId);
    }
}
