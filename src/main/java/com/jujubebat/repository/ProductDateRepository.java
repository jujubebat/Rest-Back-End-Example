package com.jujubebat.repository;

import com.jujubebat.model.ProductDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDateRepository extends JpaRepository<ProductDate, Long> {

    List<ProductDate> findByPublicAuctionNum(Long publicAuctionNum);

}
