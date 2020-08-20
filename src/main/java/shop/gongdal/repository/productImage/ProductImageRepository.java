package shop.gongdal.repository.productImage;

import shop.gongdal.model.Product;
import shop.gongdal.model.ProductDetail;
import shop.gongdal.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    List<ProductImage> findByProduct(Product product);

    List<ProductImage> findByProductId(Long productId);

}
