package com.jujubebat.repository;

import com.jujubebat.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    public List<ProductImage> findByProductId(Long productId);
}
