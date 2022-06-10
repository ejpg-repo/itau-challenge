package ejpg.untitled.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ejpg.untitled.web.dto.ErrorModel;
import ejpg.untitled.web.dto.ModelRequestDTO;
import ejpg.untitled.web.dto.ModelResponseDTO;
import ejpg.untitled.web.service.ModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;

/**
 * Responsável pelo mapeamento do endpoint de validação de senha.
 * 
 * @author eduardojr
 */
@Api(value = "REST Controller")
@RestController("/app")
public class ModelController {
  
  public ModelController() { }
  
  @Autowired
  private ModelService service;
  
  /**
   * Responsável por mapear o endpoint de validação de senha.
   * 
   * @param model modelo com o parametro a ser validado
   * @return
   */
  @PostMapping(path="/valid/password", consumes = { "application/json" })
  @ApiOperation(value = "Válida se a senha segue o padrão de segurança.", consumes = "application/json")
  @Parameter(description = "A senha a ser validada")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "a senha é valida", response = ModelResponseDTO.class),
      @ApiResponse(code = 401, message = "não autorizado", response = ErrorModel.class),
      @ApiResponse(code = 412, message = "a senha não satisfaz os critérios de segurança", response = ErrorModel.class),
      @ApiResponse(code = 500, message = "ocorreu um erro durante o processamento da solicitação", response = ErrorModel.class)
  })
  public ResponseEntity<ModelResponseDTO> valid(
      @RequestBody ModelRequestDTO model) {
    boolean isValid = service.isValid(model.getPassword());
    if (isValid) {
      return new ResponseEntity<ModelResponseDTO>(new ModelResponseDTO(isValid), HttpStatus.OK);      
    } else {
      return new ResponseEntity<ModelResponseDTO>(new ModelResponseDTO(isValid), HttpStatus.PRECONDITION_FAILED);
    }
  }
  
}
