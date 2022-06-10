package ejpg.untitled.web.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import ejpg.untitled.web.config.SpringWebConfig;

@WebAppConfiguration
@ExtendWith(value = SpringExtension.class)
@ContextConfiguration(classes = SpringWebConfig.class)
class ModelServiceTest {

  private ModelService service;
  
  @Autowired
  public ModelServiceTest(ModelService service) {
    this.service = service;
  }
  
  @Test
  void isValidTest() {
    String password1 = "AaaDDBC11"; // false
    String password2 = "Abcs2qsa"; // false
    String password3 = "Abcdefg"; // false
    String password4 = "Zyxw! v6u"; // false
    String password5 = "Ab2d!   ghj"; // false 
    String password6 = "Ab!cd3ghj"; //true
    
    assertFalse(service.isValid(password1));
    assertFalse(service.isValid(password2));
    assertFalse(service.isValid(password3));
    assertFalse(service.isValid(password4));
    assertFalse(service.isValid(password5));
    assertTrue(service.isValid(password6));
  }

}
