package br.com.atleticaAlanTuring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.atleticaAlanTuring.model.Diretor;
import br.com.atleticaAlanTuring.repository.DiretorRepository;

@Controller
public class DiretoriaController {
	

	@Autowired
	private DiretorRepository diretorRepository;
	
	
	// Diretoria
	@GetMapping("/editarDiretoria")
	public String listarDiretoria(Diretor diretor, Model model) {
		List<Diretor> diretores = diretorRepository.findAll();
		model.addAttribute("diretores", diretores);
		return "Adm/editorDiretoria";
	}
	
	@PostMapping("/cadastrardiretor")
	public String cadastrarDiretor(Diretor diretor) {
		diretorRepository.save(diretor);
		return "redirect:/editarDiretoria";
	}

	@GetMapping("/removerdiretor/{id}")
	public String removerDiretor(@PathVariable(name = "id") Long idDiretor) {
		diretorRepository.delete(idDiretor);
		return "redirect:/editarDiretoria";
	}
	
	@GetMapping(value = "/api/diretores", produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Diretor>> apiDiretores() {

		List<Diretor> diretores = diretorRepository.findAll();

		return new ResponseEntity<List<Diretor>>(diretores, HttpStatus.OK);
	}
	
	@GetMapping("/diretoria")
	public String diretoria(Model model) {		
		List<Diretor> diretores = diretorRepository.findAll();		
		model.addAttribute("diretores", diretores);
		return "diretoria";
	}

}
