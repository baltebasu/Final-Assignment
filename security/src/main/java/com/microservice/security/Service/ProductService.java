package com.microservice.security.Service;

import com.microservice.security.Dto.ProductRequest;
import com.microservice.security.Exception.ProductServiceCustomException;
import com.microservice.security.Entity.Product;
import com.microservice.security.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;



    public Product addProduct(ProductRequest productRequest ){
        Product product = null;
        product = new Product();
        product.setProductName(productRequest.getName());
        product.setProductPrice(productRequest.getPrice());
        product.setProductQty(productRequest.getQuantity());
        product.setProductCategory(productRequest.getCategory());
        return productRepository.save(product);

    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product getProductById(long id){
        return productRepository.findById(id).orElseThrow(
                () -> new ProductServiceCustomException("Product with given Id not found","PRODUCT_NOT_FOUND"));
    }

    public List<Product> getListOfProductByCategory(String category){
        List<Product> listOfProduct = null;
        listOfProduct = productRepository.findByProductCategory(category);
        if(listOfProduct.size() == 0){
            throw new ProductServiceCustomException("Product with given category not found","PRODUCT_NOT_FOUND");
        }
        return listOfProduct;
    }

    public void removeProduct(long id){
        productRepository.deleteById(id);
    }

}
