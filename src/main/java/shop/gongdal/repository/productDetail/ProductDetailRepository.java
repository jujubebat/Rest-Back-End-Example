package shop.gongdal.repository.productDetail;

import shop.gongdal.model.Product;
import shop.gongdal.model.ProductDate;
import shop.gongdal.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

    Optional<ProductDetail> findByProduct(Product product);

}
