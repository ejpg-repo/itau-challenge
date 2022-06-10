package ejpg.untitled.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Classe modelo de requisição.
 * 
 * @author eduardojr
 */
@Data
@ApiModel
public class ModelRequestDTO {

  @ApiModelProperty(value = "senha a ser validada", name = "password", example = "Ab!cd3ghj")
  private String password;
  
  public ModelRequestDTO(String password) {
    this.password = password;
  }

  public ModelRequestDTO() {}
  
}
