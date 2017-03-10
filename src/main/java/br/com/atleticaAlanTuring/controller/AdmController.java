package br.com.atleticaAlanTuring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;


import br.com.atleticaAlanTuring.model.Equipe;
import br.com.atleticaAlanTuring.repository.EquipeRepository;

@Controller
public class AdmController {

	@Autowired
	private EquipeRepository equipeRepository;


	@GetMapping("/admHome")
	public String escolherEditor() {

		return "Adm/admHome";
	}

	// Carrosel
	@GetMapping("/carrosselAdm")
	public String editarCarrosel(Model model) {
		return "Adm/editorCarrossel";
	}

	
/*	@GetMapping(value = "/api/diretores", produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Diretor>> apiDiretores() {

		List<Diretor> diretores = diretorRepository.findAll();

		return new ResponseEntity<List<Diretor>>(diretores, HttpStatus.OK);
	}*/

	// Contato

	@GetMapping("/contatoAdm")
	public String editarContato() {
		return "/Adm/editorContato";
	}

	@GetMapping("/equipesAdm")
	public String editarEquipes(Model model) {
		model.addAttribute("equipe", new Equipe());
		return "Adm/editorEquipes";
	}

	@GetMapping("/institucionalAdm")
	public String editarInstitucional() {
		return "Adm/editorInstitucional";
	}

	@PostMapping("/adicionarNovaEquipe")
	public String adicionarEquipe(Equipe equipe) {
		System.out.println(equipe);
		equipeRepository.saveAndFlush(equipe);
		return "redirect:/equipesAdm";
	}
}
