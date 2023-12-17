package com.example.DevHw17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class DevHw17Application {


	public static void main(String[] args) {
		SpringApplication.run(DevHw17Application.class, args);
	}

}
