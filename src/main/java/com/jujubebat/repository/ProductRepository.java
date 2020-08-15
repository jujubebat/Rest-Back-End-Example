package com.jujubebat.repository;

import com.jujubebat.model.Car;
import com.jujubebat.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);

    //Optional<Product> findByCLTR_MNMT_NO(Long id);

    Optional<Product> findByEx(Long id);
}
