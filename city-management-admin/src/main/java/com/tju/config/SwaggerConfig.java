package com.tju.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {


    @Bean
    public Docket docket(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        ApiInfo apiInfo = new ApiInfoBuilder().contact(new Contact("吕涵", // 文档发布者名称
                        "www.google.com",  // 文档发布者网站地址 企业网站
                        "cnlyuhan@163.com")) // 文档发布者邮箱
                .title("city-management-admin")
                .description("管理员端接口文档")
                .version("1.0")
                .build();
        docket.apiInfo(apiInfo);
        return docket;
    }

}
