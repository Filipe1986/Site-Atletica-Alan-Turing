package br.com.atleticaAlanTuring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AtleticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtleticaApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));

	}
}
