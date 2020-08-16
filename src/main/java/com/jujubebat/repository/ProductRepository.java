package com.jujubebat.repository;

import com.jujubebat.model.Car;
import com.jujubebat.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);

    Optional<Product> findByObjectManagementNum(String objectManagementNum);

    List<Product> findByObjectNameLike(String objectName);

    //@Query("SELECT * FROM Product WHERE Product.objectName LIKE %:title%")
   // @Query("SELECT product FROM Product product WHERE product.username LIKE CONCAT('%',:objectName,'%')")
   // List<Product> findByObjectNameLike(@Param("objectName") String objectName);
    //List<Product> findByObjectNameLike(@Param("title") String title);


}
