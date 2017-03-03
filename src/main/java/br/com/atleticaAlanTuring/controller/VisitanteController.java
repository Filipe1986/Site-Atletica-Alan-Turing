package br.com.atleticaAlanTuring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.atleticaAlanTuring.model.Diretor;
import br.com.atleticaAlanTuring.repository.DiretorRepository;

@Controller
public class VisitanteController {

	@Autowired
	private DiretorRepository diretorRepository;

	@GetMapping("/")
	public String index(){
		return "index";
	}

	@GetMapping("/falacomigo")
	public String contato() {
		return "contato";
	}

	@GetMapping("/diretoria")
	public String diretoria(Model model) {		
		List<Diretor> diretores = diretorRepository.findAll();		
		model.addAttribute("diretores", diretores);
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
