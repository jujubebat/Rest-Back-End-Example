package shop.gongdal.repository;

import shop.gongdal.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    Optional<Product> findByNoticeNumAndPublicAuctionNum(Long noticeNum, Long publicAuctionNum);

    Optional<Product> findByObjectManagementNum(String objectManagementNum);

    List<Product> findByObjectNameLike(String objectName);

}
