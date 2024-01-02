package com.microservice.products.service;

import com.microservice.products.Dto.ProductRequest;
import com.microservice.products.Exception.ProductServiceCustomException;
import com.microservice.products.entity.Product;
import com.microservice.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;



    public Product addProduct(ProductRequest productRequest ){
        Product product = new Product();
        product.setProductName(productRequest.getName());
        product.setProductPrice(productRequest.getPrice());
        product.setProductQty(productRequest.getQuantity());
        product.setProductCategory(productRequest.getCategory());
        return productRepository.save(product);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product getProductById(String id){
        return productRepository.findById(id).orElseThrow(
                () -> new ProductServiceCustomException("Product with given Id not found","PRODUCT_NOT_FOUND"));
    }

    public List<Product> getListOfProductByCategory(String category){
        List<Product> listOfProduct = null;
        listOfProduct = productRepository.findByCategory(category);
        if(listOfProduct.size() == 0){
            throw new ProductServiceCustomException("Product with given category not found","PRODUCT_NOT_FOUND");
        }
        return listOfProduct;
    }

}
