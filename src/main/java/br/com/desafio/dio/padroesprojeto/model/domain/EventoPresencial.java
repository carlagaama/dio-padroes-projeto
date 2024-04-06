package br.com.desafio.dio.padroesprojeto.model.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventoPresencial {
    private Endereco endereco;
    private Clima clima;


}
