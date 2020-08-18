package com.jujubebat.repository;

import com.jujubebat.model.Product;
import com.jujubebat.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
    Optional<ProductDetail> findByPublicAuctionNum(Long publicAuctionNum);
}
