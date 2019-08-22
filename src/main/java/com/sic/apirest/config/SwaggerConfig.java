package com.sic.apirest.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sic.apirest"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

       /* ApiInfo apiInfo = new ApiInfo(
                "SIC API REST",
                "API REST GERENCIAMENTO DO SISTEMA DA IGREJA CENTRAL.",
                "1.0",
                "Terms of Service",
                new Contact("Michelli Brito", "https://www.youtube.com/michellibrito",
                        "michellidibrito@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );*/
        ApiInfo apiInfo = new ApiInfo(
                "SIC API REST",
                "API REST GERENCIAMENTO DO SISTEMA DA IGREJA CENTRAL.",
                "1.0",
                "Terms of Service",
                new Contact("Joelson de Sousa Silva", "https://www.campogrande.ms.gov.br",
                        "joelson.s.s@outlook.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );
        /**
         * Acesso via contexto.../swagger-ui.html
         * */

        return apiInfo;
    }

}
