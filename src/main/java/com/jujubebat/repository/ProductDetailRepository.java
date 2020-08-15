package com.jujubebat.repository;

import com.jujubebat.model.Product;
import com.jujubebat.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
}
