package com.jujubebat.repository;

import com.jujubebat.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findById(Long id);
    List<Car> findBySpeed(String speed);
    List<Car> findAll();
}
