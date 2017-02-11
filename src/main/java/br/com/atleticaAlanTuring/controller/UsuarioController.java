package br.com.atleticaAlanTuring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.atleticaAlanTuring.model.Usuario;
import br.com.atleticaAlanTuring.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping("/")
	public String inicio(Model model) {
		System.out.println("entrando no index");
		model.addAttribute("usuario", new Usuario());
		return "index";
	}

	@PostMapping("/")
	public String gravarUsuario(Usuario usuario) {
		System.out.println(usuario);
		usuarioRepository.saveAndFlush(usuario);
		System.out.println("Usuario " + usuario.getNome() + " salvo!");
		return "redirect:/";

	}

}
