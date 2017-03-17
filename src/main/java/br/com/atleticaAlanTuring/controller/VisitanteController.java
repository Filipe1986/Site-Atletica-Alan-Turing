package br.com.atleticaAlanTuring.controller;


import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	public String sejaSocio() {
		return "sejaSocio";
	}

}
