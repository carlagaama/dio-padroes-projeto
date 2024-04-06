package br.com.desafio.dio.padroesprojeto.model.domain;

import br.com.desafio.dio.padroesprojeto.model.domain.enums.TipoEventoEnum;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;


@Builder
@Data
public class Evento {
    private UUID id;
    private String nome;
    private String descricao;
    private LocalDateTime horario;

    private TipoEventoEnum tipoEvento;
    private EventoPresencial presencial;
    private EventoRemoto remoto;


}
