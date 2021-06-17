package com.grupo2.TFCidaderaClone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.grupo2" })
@EntityScan(basePackages = { "com.grupo2" })
public class CtrlTfCidaderaCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CtrlTfCidaderaCloneApplication.class, args);
	}

}
