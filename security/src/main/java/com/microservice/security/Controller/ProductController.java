package com.microservice.security.Controller;

import com.microservice.security.Dto.ProductRequest;
import com.microservice.security.Entity.Product;
import com.microservice.security.Service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/micro")
@Api(value="User Product API endpoints which are used to interact with all microservices ")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/welcome")
    @ApiOperation(value = "Testing controller")
    public ResponseEntity<String> getProductById() {
        return new ResponseEntity<>("welcome to product service", HttpStatus.OK);
    }

    @PostMapping(value = "/product/addProduct")
    @ApiOperation(value = "this service help to add the product in to the system by admin")
    @PreAuthorize("hasAuthority('Admin')")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the JWT Token"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Requested Resource Not Found")
    })
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequest productRequest) {
        return new ResponseEntity<>(productService.addProduct(productRequest), HttpStatus.CREATED);
    }

    @GetMapping("/product/{id}")
    @ApiOperation(value = "this service help to view the product by id in the system by both admin and user")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productId) {
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

    @GetMapping("/product/allProducts")
    @ApiOperation(value = "this service help to view the product in the system by both admin and user")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/product/category/{id}")
    @ApiOperation(value = "this service help to view the product based on category")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("id") String productCategory) {
        return new ResponseEntity<>(productService.getListOfProductByCategory(productCategory), HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    @ApiOperation(value = "this service help to delete the product by admin ")
    @PreAuthorize("hasAuthority('Admin')")
    public void deleteProductById(@PathVariable("id") long productId) {
        productService.removeProduct(productId);
    }



}
