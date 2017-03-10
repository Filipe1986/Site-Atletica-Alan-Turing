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
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.atleticaAlanTuring.model.Evento;
import br.com.atleticaAlanTuring.repository.EventoRepository;

@Controller
public class AgendaController {

	@Autowired
	private EventoRepository eventoRepository;

	@GetMapping("/agenda")
	public String agenda() {
		return "agenda";
	}

	@GetMapping("/editarAgenda")
	public String listareEventos(Evento evento, Model model) {
		List<Evento> eventos = eventoRepository.findAll();
		model.addAttribute("eventos", eventos);
		return "Adm/editorAgenda";
	}

	@PostMapping("/cadastrareventos")
	public String cadastrarEvento(Evento evento) {
		eventoRepository.save(evento);
		return "redirect:/editarAgenda";
	}

	@GetMapping("/removerevento/{id}")
	public String removerEvento(@PathVariable(name = "id") Long idEvento) {
		eventoRepository.delete(idEvento);
		return "redirect:/editarAgenda";
	}

	@GetMapping(value = "/api/eventos.json", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Evento>> apiEventos() {

		List<Evento> eventos = eventoRepository.findAll();

		return new ResponseEntity<List<Evento>>(eventos, HttpStatus.OK);
	}

}
