package br.com.atleticaAlanTuring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitanteController {

	@GetMapping("/falacomigo")
	public String contato() {
		return "contato";
	}

	@GetMapping("/diretoria")
	public String diretoria() {
		return "diretoria";
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
	public String sejaSocio() {
		return "sejaSocio";
	}

	@GetMapping("/produtos")
	public String produtos() {
		return "produtos";
	}

	@GetMapping("/agenda")
	public String agenda() {
		return "agenda";
	}
}
