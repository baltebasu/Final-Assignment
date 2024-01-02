package com.microservice.security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Collections;

/*@Configuration
@EnableSwagger2*/
public class SwaggerConfig {

   /* @Bean
    public Docket userAccountApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo(){
        return new ApiInfo("User Microservice",
                "User Microservice for online shopping ecommerce application",
                "1.0 V",
                "terms of Url",
                new Contact("Basaveshwar","bbalte@altimetrik.com","1234567890"),
                "license",
                "licenseUrl",
                Collections.emptyList());
    }*/
}




