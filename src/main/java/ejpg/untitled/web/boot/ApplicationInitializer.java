package ejpg.untitled.web.boot;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ejpg.untitled.web.dto.ErrorModel;

/**
 * Responsável por inicializar a aplicação Spring Boot, 
 * e mapear o contexto de controle de erros.
 * 
 * @author eduardojr
 */
@RestController
@SpringBootApplication(scanBasePackages = { "ejpg.untitled.web.config" } )
public class ApplicationInitializer implements ErrorController {

  /**
   * Método de inicialização de aplicação executável em JVM.
   * @param args argumento padrão de entrada de dados da aplicação, 
   * pode ser deixado em branco neste cenário.
   */
  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(ApplicationInitializer.class);
    app.setDefaultProperties(Collections.singletonMap("server.port", "8010"));
    app.run(args);
  }
  
  /**
   * Método com mapeamento para tratamento de mensagens de erro.
   * @return RequestEntity<ErrorModel>
   */
  @GetMapping(path = "/error")
  public RequestEntity<ErrorModel> error() {
    return new RequestEntity<ErrorModel>(null, null);
  }
  
}
