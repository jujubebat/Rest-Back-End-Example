package shop.gongdal.repository;

import shop.gongdal.model.Product;
import shop.gongdal.model.ProductDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDateRepository extends JpaRepository<ProductDate, Long> {

    List<ProductDate> findByPublicAuctionNum(Long publicAuctionNum);

    List<ProductDate> findByProduct(Product product);

}
