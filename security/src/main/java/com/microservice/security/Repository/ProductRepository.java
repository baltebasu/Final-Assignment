package com.microservice.security.Repository;

import com.microservice.security.Entity.Product;
import com.microservice.security.Entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "select u from Product u where u.productCategory = :productCategory")
    List<Product> findByProductCategory(String productCategory);
}
