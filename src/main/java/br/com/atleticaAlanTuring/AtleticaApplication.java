package br.com.atleticaAlanTuring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@SpringBootApplication
public class AtleticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtleticaApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));

	}

}
