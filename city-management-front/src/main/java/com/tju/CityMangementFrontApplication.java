package com.tju;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* @description: TODO
* @author user
* @date 2023/10/15 18:25
* @version 1.0
*/


@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
@ServletComponentScan
public class CityMangementFrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityMangementFrontApplication.class, args);
    }
}
