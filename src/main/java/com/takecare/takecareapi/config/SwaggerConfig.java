package com.takecare.takecareapi.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
    
    @Autowired
    private BuildProperties buildProperties;

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        .groupName("takecare-api")
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.takecare.takecareapi.api"))
        .paths(regex("/.*"))
        .build()
        .apiInfo(apiInfo(buildProperties.getVersion()));
    }

    @Bean
	public WebMvcConfigurer forwardToIndex() {
		return new WebMvcConfigurer() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/swagger").setViewName("redirect:/swagger-ui.html");
			}
		};
	}

	private ApiInfo apiInfo(String version) {
		return new ApiInfoBuilder()
				.title("TakeCare API")
				.description("\"REST API to provide integration between the mobile application and the website with database\"")
				.version(version)
				.contact(new Contact("Gabriel Lucas Costa Lima", "", "gabriel23costalima@outlook.com"))
				.build();
	}
}