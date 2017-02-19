package br.com.atleticaAlanTuring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.atleticaAlanTuring.model.Membro;
import br.com.atleticaAlanTuring.repository.MembroRepository;

@Controller
public class AdmController {

	@Autowired
	private MembroRepository membroRepository;

	@GetMapping("/admHome")
	public String escolherEditor() {
		System.out.println("Entrou na página inicial de Edição do administrador");
		return "Adm/admHome";
	}

	@GetMapping("/carroselAdm")
	public String editarCarrosel() {
		System.out.println("Entrou na página de Edição do carrosel");
		return "Adm/editorCarrosel";
	}

	@GetMapping("/produtoAdm")
	public String editarProdutos() {
		return "Adm/editorProduto";

	}

	@GetMapping("/agendaAdm")
	public String editarAgenda() {
		return "Adm/editorAgenda";
	}

	@GetMapping("/diretoriaAdm")
	public String editarDiretoria() {
		System.out.println("Entrou na página de Edição do carrosel");
		return "Adm/editorDiretoria";
	}

	@GetMapping("/contatoAdm")
	public String editarContato() {
		return "/Adm/editorContato";
	}

	@GetMapping("/equipesAdm")
	public String editarEquipes() {
		return "Adm/editorEquipes";
	}

	@GetMapping("/institucionalAdm")
	public String editarInstitucional() {
		System.out.println("Entrou na página de Edição do carrosel");
		return "Adm/editorInstitucional";
	}

	@GetMapping("/painelAdm")
	public String editarPainel() {
		System.out.println("Entrou na página de Edição do carrosel");
		return "Adm/editorPainel";
	}

	@GetMapping("/membrosAdm")
	public String editarMembros(Model model) {

		model.addAttribute("membro", new Membro());

		return "Adm/editorMembros";
	}

	@PostMapping("/adicionarNovoMembro")
	public String adicionarMembro(Membro membro) {
		System.out.println("Nome membro : " + membro.getNomeMembro() + "Diretoria :" + membro.getDiretoria());
		membroRepository.saveAndFlush(membro);
		return "redirect:/membrosAdm";
	}

}
