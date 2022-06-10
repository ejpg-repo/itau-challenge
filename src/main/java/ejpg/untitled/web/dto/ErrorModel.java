package ejpg.untitled.web.dto;

import lombok.Data;

/**
 * Classe modelo para mensagens de erro.
 * 
 * @author eduardojr
 */
@Data
public class ErrorModel {
  
  private String message;
  private int code;
  
}
