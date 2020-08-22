package shop.gongcar.repository.productDate;

import shop.gongcar.model.Product;
import shop.gongcar.model.ProductDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDateRepository extends JpaRepository<ProductDate, Long> {

    List<ProductDate> findByProduct(Product product);

}
