package br.com.desafio.dio.padroesprojeto.service.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface EnderecoService {
    @GetMapping("/{cep}/json/")
    EnderecoResponse consultarCep(@PathVariable("cep") String cep);
}
