package br.com.atleticaAlanTuring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.atleticaAlanTuring.model.Equipe;
import br.com.atleticaAlanTuring.model.Membro;
import br.com.atleticaAlanTuring.model.Produto;
import br.com.atleticaAlanTuring.repository.EquipeRepository;
import br.com.atleticaAlanTuring.repository.MembroRepository;
import br.com.atleticaAlanTuring.repository.ProdutoRepository;

@Controller
public class AdmController {

	@Autowired
	private MembroRepository membroRepository;

	@Autowired
	private EquipeRepository equipeRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("/admHome")
	public String escolherEditor() {

		return "Adm/admHome";
	}

	@GetMapping("/carroselAdm")
	public String editarCarrosel() {

		return "Adm/editorCarrosel";
	}

	@GetMapping("/produtoAdm")
	public String editarProdutos(Model model) {
		model.addAttribute("produto", new Produto());
		return "Adm/editorProduto";

	}

	@GetMapping("/agendaAdm")
	public String editarAgenda() {
		return "Adm/editorAgenda";
	}

	@GetMapping("/diretoriaAdm")
	public String editarDiretoria() {
		return "Adm/editorDiretoria";
	}

	@GetMapping("/contatoAdm")
	public String editarContato() {
		return "/Adm/editorContato";
	}

	@GetMapping("/equipesAdm")
	public String editarEquipes(Model model) {
		model.addAttribute("equipe", new Equipe());
		return "Adm/editorEquipes";
	}

	@GetMapping("/membrosAdm")
	public String editarMembros(Model model) {
		List<Membro> membros = membroRepository.findAll();
		model.addAttribute("membros", membros);
		model.addAttribute("membro", new Membro());

		return "Adm/editorMembros";
	}

	@GetMapping("/institucionalAdm")
	public String editarInstitucional() {

		return "Adm/editorInstitucional";
	}

	@GetMapping("/painelAdm")
	public String editarPainel() {

		return "Adm/editorPainel";
	}

	@PostMapping("/adicionarNovoMembro")
	public String adicionarMembro(Membro membro) {
		System.out.println("Nome membro : " + membro.getNomeMembro() + "Diretoria :" + membro.getDiretoria());
		membroRepository.saveAndFlush(membro);
		return "redirect:/membrosAdm";
	}

	@PostMapping("/adicionarNovaEquipe")
	public String adicionarEquipe(Equipe equipe) {
		System.out.println(equipe);
		equipeRepository.saveAndFlush(equipe);
		return "redirect:/equipesAdm";
	}

	@PostMapping("/adicionarNovoProduto")
	public String adicionarProduto(Produto produto) {
		produtoRepository.saveAndFlush(produto);
		return "redirect:/produtoAdm";
	}

}
