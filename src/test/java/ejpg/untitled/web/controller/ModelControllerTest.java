package ejpg.untitled.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import ejpg.untitled.web.config.SpringWebConfig;
import ejpg.untitled.web.dto.ModelRequestDTO;

@WebAppConfiguration
@ExtendWith(value = SpringExtension.class)
@ContextConfiguration(classes = SpringWebConfig.class)
class ModelControllerTest {

  private WebApplicationContext context;
  private MockMvc mockMvc;

  @Autowired
  private ModelControllerTest(WebApplicationContext context) {
    this.context = context;
  }

  @BeforeEach
  void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  void isValidHTTP200() throws Exception {

    ModelRequestDTO req = new ModelRequestDTO("Ab!cd3ghj");
    ObjectMapper mapper = new ObjectMapper();
    byte[] content = mapper.writeValueAsBytes(req);

    mockMvc.perform(post("/valid/password").contentType("application/json").content(content))
        .andExpect(status().isOk());
  }

  @Test
  void isValidHTTP412() throws Exception {
    ModelRequestDTO req = new ModelRequestDTO("weakpassword");
    ObjectMapper mapper = new ObjectMapper();
    byte[] content = mapper.writeValueAsBytes(req);

    mockMvc.perform(post("/valid/password").contentType("application/json").content(content))
        .andExpect(status().isPreconditionFailed());
  }
  
}
