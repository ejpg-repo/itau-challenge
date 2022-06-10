package ejpg.untitled.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Responsável por mapear os contextos de dependência de inicialização.
 * 
 * @author eduardojr
 *
 */
@EnableWebMvc
@Configuration
@ComponentScan(value = { "ejpg.untitled.web.controller", "ejpg.untitled.web.service" })
public class SpringWebConfig {
  
}
