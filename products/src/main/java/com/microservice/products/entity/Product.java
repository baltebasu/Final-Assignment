package com.microservice.products.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    @Id
    private String productId;
    private String productName;
    private long productPrice;
    private String productCategory;
    private long productQty;
}
