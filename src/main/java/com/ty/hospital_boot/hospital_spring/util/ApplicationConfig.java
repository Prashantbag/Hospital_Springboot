package com.ty.hospital_boot.hospital_spring.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {

	@Bean
	public Docket getDocket() {
		Contact contact= new Contact("Testyantra", "testyantra.com", "testyantra@gmail.com");
		
		List<VendorExtension> extension = new ArrayList<VendorExtension>();
		
		ApiInfo apiInfo = new ApiInfo("Hospital Management", "Hospital App ", "1.0", "hospitalapp.com", contact, "apache tomcat", "www.apache.com", extension);
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.ty.hospital_boot.hospital_spring")).build();
	}
}
