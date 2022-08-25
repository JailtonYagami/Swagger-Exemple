package com.jailtoncode.todolistyoutube.docs;

import com.fasterxml.classmate.TypeResolver;
import com.jailtoncode.todolistyoutube.model.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfiguration {


    @Bean
    public Docket swagger(TypeResolver typeResolver) {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())//("com.jailtoncode.todolistyoutube")
                .paths(PathSelectors.any())//(PathSelectors.regex("api/v1"))
                .build()
                .useDefaultResponseMessages(true)
                .apiInfo(metaInfo());



    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("To do List - Youtube")
                .description("Aplicacao gerenciadora de tarefas")
                .version("0.0.1")
                .build();
    }

    private ApiInfo metaInfo(){

        ApiInfo apiInfo = new ApiInfo(
                "To do List - Youtube",
                "API REST gerenciadora de tarefas",
                "0.0.1",
                "Terms of Service",
                new Contact("Jailton Gilberto","https://www.linkedin.com/in/jailton-gilberto/",
                        "jailtonryuji1@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licensen.html", new ArrayList<VendorExtension>()

        );
        return apiInfo;
    }

}
