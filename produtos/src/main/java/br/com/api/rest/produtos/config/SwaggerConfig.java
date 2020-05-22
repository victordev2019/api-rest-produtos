package br.com.api.rest.produtos.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
	return new Docket(DocumentationType.SWAGGER_2)
	.select()
	.apis(RequestHandlerSelectors.basePackage("br.com.api.rest.produtos"))
	.build()
	.apiInfo(metaData());
	
}

	private ApiInfo metaData() {
		return new ApiInfoBuilder()
				.title("PRODUTOS REST API")
				.description("Spring Boot REST API de Cadastro de Produtos")
				.version("1.0")
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.contact(new Contact("Victor Hugo Ferreira", "https://github.com/victordev2019"
						, "vitorsam.hugo@gmail.com"))
				.build();
	}
}
