package br.com.atleticaAlanTuring.controller;


import java.io.File;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.atleticaAlanTuring.model.Email;

@Controller
public class VisitanteController {

	@GetMapping("/")
	public String index() {

		return "index";
	}

	@GetMapping("/falacomigo")
	public String contato() {
		return "contato";
	}

	@GetMapping("/meustimes")
	public String equipe() {
		return "equipes";

	}

	@GetMapping("/quemsoueu")
	public String institucionalVisitante() {

		return "institucional";
	}

	@GetMapping("/sejasocio")
	public String sejaSocio( Model model) {
		model.addAttribute("email", new Email());
		return "sejaSocio";
	}
	
	@PostMapping("/enviarEmail")
	public String enviarEmail(Email email, Model model, RedirectAttributes atributo) {
		
		System.out.println("Email" + email.toString());
		SimpleEmail simpleEmail = new SimpleEmail();
		
		try {
			
			//Remetente
			simpleEmail.setFrom(email.getRemetente(), email.getNome());
			simpleEmail.setAuthentication(email.getRemetente(), "suaSenha");
			simpleEmail.setHostName("smtp.gmail.com");
	        simpleEmail.setSmtpPort(465);  
			//Destinatário
			simpleEmail.addTo("Email@destinatario.com");
			
			simpleEmail.setSubject("Junte-se a nós");
			simpleEmail.setMsg("Mensagem padrão de envio de interessado em se associar a atlética"
					+ "\nInteressado: " + email.getNome() + " " + email.getSobrenome()+
						"\nMatrícula: "+ email.getMatricula() + " Período: "+ email.getPeriodo());
			simpleEmail.setSSL(true);
			simpleEmail.send();
			atributo.addFlashAttribute("sucesso", "Email enviado!");

		} catch (EmailException e) {
			atributo.addFlashAttribute("erro", "Email não enviado!");
			e.printStackTrace();
		}

		return "redirect:sejasocio";
	}

	


}
