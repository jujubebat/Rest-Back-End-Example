package shop.gongcar.repository.productDetail;

import shop.gongcar.model.Product;
import shop.gongcar.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

    Optional<ProductDetail> findByProduct(Product product);

}
