package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
/**
 * @Configuration means that the annotated class is defining a Spring configuration,
 * @EnableSwagger2 turns on the Swagger support.
 * The Docket is a builder class to configure the generation of Swagger documentation, configured with DocumentationType.SWAGGER_2 to generate Swagger 2 compatible API documentation
 * The select() method called on the Docket bean instance returns an ApiSelectorBuilder, which provides the apis() and paths() methods to filter the controllers and methods being documented using string predicates.
 * In our example, we want all controllers and all mapped paths to be documented; that's why we use .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())
 *
 * for api docs
 * http://localhost:8080/v2/api-docs
 *
 * for ui
 * http://localhost:8080/swagger-ui.html
 */
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }
}
