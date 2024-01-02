package com.microservice.security.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    @Id
    private long productId;
    private String productName;
    private long productPrice;
    private String productCategory;
    private long productQty;
}
