package com.infogain.debonair.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class is Swagger configuration class.
 * 
 * @author Chetna
 * @since 04-May-2020
 */
@Configuration
@EnableSwagger2
public class DebonairSwaggerConfig {
	/**
	 * This method is to return Docket object which provides Swagger documentation
	 * type and indicates the controller packages.
	 * 
	 * @return Docket Object
	 * @since 04-May-2020
	 */
	@Bean
	public Docket debonairApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.infogain.debonair.controllers")).build();
	}

	/**
	 * This method is used to provide documentation information to Swagger
	 * 
	 * @return
	 * @since 04-May-2020
	 */
	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Debonair Restaurant").description("This is Swagger of Debonair Services")
				.version("1.0").build();
	}

}
