package ru.ilka.jogger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@EnableWebMvc
//@EnableCaching
@ComponentScan(value = "ru.ilka.jogger")
@PropertySource("classpath:application.properties")
public class WebMvcConfig {

    /* Swagger Documentation
    http://localhost:8088/api/v2/api-docs
    http://localhost:8088/api/swagger-ui.html
    */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.ilka.jogger.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Jogger REST API",
                "Backend app for jogging",
                "1.0",
                "Terms of service",
                new Contact("Ilya Kisel", "https://github.com/llka/", "ilyakisel730@gmail.com"),
                "License of API", "https://github.com/llka/", Collections.emptyList());
    }

}
