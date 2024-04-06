package br.com.desafio.dio.padroesprojeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PadroesProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesProjetoApplication.class, args);
	}

}
