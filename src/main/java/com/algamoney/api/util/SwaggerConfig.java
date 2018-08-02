package com.algamoney.api.util;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

//	@Bean
//	public Docket sobreAPI() {
//		
//		Docket docket = new Docket(DocumentationType.SWAGGER_2);
//		docket.select()
//			.apis(RequestHandlerSelectors.basePackage("com.algamoney.api"))
//			.paths(PathSelectors.any())
//			.build()
//			.securitySchemes(Arrays.asList(securityScheme()))
//			.securityContexts(Arrays.asList(securityContext()))
//			.apiInfo(this.detalhesAPI().build());
//		
//		return docket;
//	}
//
//	private SecurityContext securityContext() {
//		return null;
//	}
//
//	private SecurityScheme securityScheme() {
//		return null;
//	}
//	
//	private ApiInfoBuilder detalhesAPI() {
//		
//		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
//		
//		apiInfoBuilder.title(DetalhesAPIEnum.TITULO.getDetalhe());
//		apiInfoBuilder.description(DetalhesAPIEnum.DESCRICAO.getDetalhe());
//		apiInfoBuilder.version(DetalhesAPIEnum.VERSAO.getDetalhe());
//		apiInfoBuilder.termsOfServiceUrl(DetalhesAPIEnum.TERMOS_DE_SERVICO.getDetalhe());
//		apiInfoBuilder.license(DetalhesAPIEnum.LICENCA.getDetalhe());
//		apiInfoBuilder.licenseUrl(DetalhesAPIEnum.LICENCA_URL.getDetalhe());
//		apiInfoBuilder.contact(this.contato());
//		
//		return apiInfoBuilder;
//	}
//
//	private Contact contato() {
//		return new Contact(ContatoAPIEnum.NOME.getInfoContato(),ContatoAPIEnum.URL.getInfoContato() ,ContatoAPIEnum.EMAIL.getInfoContato());
//	}
}
