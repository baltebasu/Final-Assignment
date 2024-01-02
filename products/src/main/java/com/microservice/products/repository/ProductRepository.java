package com.microservice.products.repository;

import com.microservice.products.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {

    @Query(value="{productCategory:'?0'}", fields="{'productName' : 1, 'productQty' : 1,'productPrice' :1 }")
    List<Product> findByCategory(String productCategory);

}
