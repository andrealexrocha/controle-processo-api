package com.seplag.services.process;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ProcessApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessApplication.class, args);
	}

	@Bean
	public Docket processApplicationApiV1() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("v1").select()
				.apis(RequestHandlerSelectors.basePackage("com.seplag.services.process.v1.controllers"))
				.paths(PathSelectors.any()).build().apiInfo(new ApiInfoBuilder().title("Controle de Benefício API v1")
						.version("1.0").description("API para uma aplicação de controle de benefícios.").build());
	}

	@Bean
	public Docket processApplicationApiV2() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("v2").select()
				.apis(RequestHandlerSelectors.basePackage("com.seplag.services.process.v2.controllers"))
				.paths(PathSelectors.any()).build().apiInfo(new ApiInfoBuilder().title("Controle de Benefício API v2")
						.version("2.0").description("API para uma aplicação de controle de benefícios.").build());
	}
}
