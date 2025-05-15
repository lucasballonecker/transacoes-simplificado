package com.lucasballonecker.transacoes_simplificado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TransacoesSimplificadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransacoesSimplificadoApplication.class, args);
	}

}
