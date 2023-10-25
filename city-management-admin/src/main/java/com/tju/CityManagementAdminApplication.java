package com.tju;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
@ServletComponentScan
public class CityManagementAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityManagementAdminApplication.class, args);
    }

}
