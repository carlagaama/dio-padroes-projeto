package br.com.desafio.dio.padroesprojeto.model.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Clima {
    private String descricao;
    private float temperatura;
}
