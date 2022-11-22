package com.assignment.eventmanagement.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metadata());
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Event Management API application")
                .description("API documentation for Event Management Application")
                .version("1.1.0")
                .contact(new Contact("Clarence DSilva", "https://www.linkedin.com/in/clarencedsilva/","clarencedsilva24@gmail.com"))
                .build();
    }
}
