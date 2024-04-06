package br.com.desafio.dio.padroesprojeto.model.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

}
