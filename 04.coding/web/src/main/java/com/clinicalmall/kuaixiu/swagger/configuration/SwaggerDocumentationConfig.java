package com.clinicalmall.kuaixiu.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@EnableWebMvc
@EnableSwagger2
// Loads the spring beans required by the framework
public class SwaggerDocumentationConfig {

	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("云快修").description("云快修接口定义 ")
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.termsOfServiceUrl("").version("1.0.0")
				.contact(new Contact("", "", "jiff.zuo@gmail.com")).build();
	}

	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
						.basePackage("com.clinicalmall.kuaixiu.controller"))
				.build()
				.directModelSubstitute(java.time.LocalDate.class,
						java.sql.Date.class)
				.directModelSubstitute(java.time.OffsetDateTime.class,
						java.util.Date.class).apiInfo(apiInfo());
	}

	@Bean
	public Jackson2ObjectMapperBuilder builder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
				.indentOutput(true)
				.featuresToDisable(
						SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
				.dateFormat(new RFC3339DateFormat());
		return builder;
	}

	@Bean
	public ObjectMapper objectMapper() {
		return builder().build();
	}
}
