package com.example;

import com.example.services.FlywayMigration;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {


	@SneakyThrows
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		new FlywayMigration().flywayMigration();
	}

}






