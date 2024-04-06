package br.com.desafio.dio.padroesprojeto.model.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EnderecoRequest {
    private String cep;
    private String complemento;
}
