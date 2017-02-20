package br.com.atleticaAlanTuring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.atleticaAlanTuring.model.Usuario;
import br.com.atleticaAlanTuring.repository.UsuarioRepository;

@Controller
public class VisitanteController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "index";
	}

	/*
	
	 @PostMapping("/")
	public String gravarUsuario(Usuario usuario) {
		System.out.println(usuario);
		usuarioRepository.saveAndFlush(usuario);
		System.out.println("Usuario " + usuario.getNome() + " salvo!");
		return "redirect:/";

	} */

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
