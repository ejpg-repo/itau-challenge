package ejpg.untitled.web.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

/**
 * Responsável por resolver a solicitação.
 * 
 * @author eduardojr
 *
 */
@Service
public class ModelService {
  
  /**
   * (?=.*[0-9]) ao menos um digito
   * (?=.*[a-z]) ao menos uma letra minuscula
   * (?=.*[A-Z]) ao menos uma letra maiuscula
   * (?=.*[!@#$%^&*()-+_]) ao menos um caracter especial
   * (?:([0-9a-zA-Z!@#$%^&*()-+_])(?!\1)) grupo de não captura
   * {9,} limitador de quantidade de caracter
   */
  private static final Pattern pattern = 
      Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-+_])(?:([0-9a-zA-Z!@#$%^&*()-+_])(?!\\1)){9,}$");
  
  /**
   * Responsável por validar a regra de senha segura.
   * definida pelos padrão: deve conter ao menos uma letra minuscula,
   * ao menos uma letra maiuscula, ao menos um número, ao menos um 
   * caracter especial, tamanho minimo de  9 caracteres, não possuir
   * caracter repetido, não deve conter espaço e tabulação.
   * 
   * Caracteres especiais: !@#$%^&*()-+_
   * 
   * @param password
   * @return Boolean - a validacao da senha informada
   */
  public Boolean isValid(String password) {
    return pattern.matcher(password).matches();
  }
  
}
