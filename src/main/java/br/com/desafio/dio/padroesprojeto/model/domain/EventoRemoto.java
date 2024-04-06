package br.com.desafio.dio.padroesprojeto.model.domain;

import br.com.desafio.dio.padroesprojeto.model.domain.enums.ProvedorEnum;
import br.com.desafio.dio.padroesprojeto.model.domain.enums.TipoEventoEnum;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EventoRemoto {

    private ProvedorEnum provedor;
    private String link;


}
