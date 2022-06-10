package ejpg.untitled.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Classe modelo de resposta.
 * 
 * @author eduardojr
 */
@Data
@ApiModel
public class ModelResponseDTO {

  @JsonProperty(value = "is_valid")
  @ApiModelProperty(value = "valor verdadeiro ou falso", name = "valid", example = "true")
  public Boolean valid;

  public ModelResponseDTO(Boolean valid) {
    this.valid = valid;
  }
  
  public ModelResponseDTO() {}
  
}
