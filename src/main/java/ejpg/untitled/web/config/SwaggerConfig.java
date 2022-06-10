package ejpg.untitled.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Responsável por fornecer configurações ao Swagger.
 * 
 * @author eduardojr
 */
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

  /**
   * Método de parametrização das configurações do SprigngFox
   * 
   * @return Docket classe de configuração do SpringFox
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("ejpg.untitled.web.controller"))
        .build()
        .useDefaultResponseMessages(false)
        .apiInfo(apiInfo());
  }
  
  /**
   * Método de parametrização de informações adicionais da API.
   * 
   * @return ApiInfo classe de configuração de informações
   * adicionais para rederização na documentação da API.
   */
  public ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Itaú Challenge")
        .description("API REST para validação de senha.")
        .version("1.0")
        .build();
  }
  
  /**
   * Responsável por adicionar indentificadores de recursos do swagger.
   * 
   * @param 
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {    
    registry.addResourceHandler("swagger-ui.html")
    .addResourceLocations("classpath:/META-INF/resources/");
    
    registry.addResourceHandler("/webjars/**")
    .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }

}
