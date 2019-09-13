package com.kino.shop;

import com.kino.shop.model.Token;
import com.kino.shop.model.User;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2);
    }

    @Configuration
    public static class RepositoryConfig extends RepositoryRestConfigurerAdapter {
        @Override
        public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
            config.exposeIdsFor(User.class);
            config.exposeIdsFor(Token.class);
        }
    }

    @RestController
    public static class RestCont {

        //TODO: use this endpoint to test security config
        @ApiImplicitParam(name = "Authorization", value = "Access Token", required = false, allowEmptyValue = true, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
        @PreAuthorize("hasAuthority('ADMIN')")
        @RequestMapping("/hello")
        public String hello() {
            System.out.println(SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
            System.out.println("Hello");
            return "Hello";
        }
    }
}