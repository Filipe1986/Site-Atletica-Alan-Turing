package br.com.atleticaAlanTuring.infra;

import java.io.File;
import java.io.IOException;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Arquivador {
	
	 @Autowired
	 private ServletContext servletContext;

	
	public String write(String pastaBase, MultipartFile file){
		try {
			
			
		
			
			
			String path = "../atletica/src/main/resources/img/" + file.getOriginalFilename();
			System.out.println("nome do caminho : " + path);
			file.transferTo(new File(path));
			
			return path;
		} catch (IllegalStateException | IOException e) {
			System.out.println("execption");
			throw new RuntimeException(e);
		}
		
	}

}
