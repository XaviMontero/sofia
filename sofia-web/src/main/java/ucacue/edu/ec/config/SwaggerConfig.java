package ucacue.edu.ec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    
	@Bean
	public Docket v1APIConfiguration() {
		return new Docket(
				DocumentationType.SWAGGER_2).groupName("v1").select()
				.apis(RequestHandlerSelectors.basePackage("ucacue.edu.ec.api"))
				.paths(PathSelectors.regex("/api/v1.0/.*")).build().apiInfo(new ApiInfoBuilder().version("1.0")
						.title("Sofia API 1.0").description("Documentation Sofia API v1.0").build());
	}
	
}