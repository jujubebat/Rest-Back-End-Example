package shop.gongdal.repository;

import shop.gongdal.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

    Optional<ProductDetail> findByPublicAuctionNum(Long publicAuctionNum);

}
