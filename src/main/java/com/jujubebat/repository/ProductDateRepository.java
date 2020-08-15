package com.jujubebat.repository;

import com.jujubebat.model.ProductDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDateRepository extends JpaRepository<ProductDate, Long> {
}
