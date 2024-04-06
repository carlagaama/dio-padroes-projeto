package br.com.desafio.dio.padroesprojeto.model.dto.request;

import br.com.desafio.dio.padroesprojeto.model.domain.enums.ProvedorEnum;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EventoRequest {
    private String nome;
    private String descricao;
    private LocalDateTime horario;
    private EnderecoRequest endereco;
    private ProvedorEnum provedor;
    private String link;
    private boolean indicadorEventoRemoto;
}
