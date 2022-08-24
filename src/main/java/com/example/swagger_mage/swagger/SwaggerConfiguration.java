package com.example.swagger_mage.swagger;


import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static java.util.Collections.singletonList;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Rest api")
                .description("描述")
                .version("1.2.3")
                .build();
    }

    private List<SecurityScheme> apiKey() {
        return singletonList(new ApiKey("JWT", "Authorization", "header"));
    }

    private List<SecurityContext> securityContext() {
        return singletonList(SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build());
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return singletonList(new SecurityReference("JWT", authorizationScopes));
    }

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger_mage"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes((apiKey()))
                .securityContexts(securityContext())
                .directModelSubstitute(ResponseEntity.class, Void.class)
                .protocols(Sets.newHashSet("http", "https"))
                ;
    }

}

