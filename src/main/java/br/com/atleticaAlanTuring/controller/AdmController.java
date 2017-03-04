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
import br.com.atleticaAlanTuring.model.Equipe;
import br.com.atleticaAlanTuring.model.Membro;
import br.com.atleticaAlanTuring.model.Produto;
import br.com.atleticaAlanTuring.repository.DiretorRepository;
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

	@Autowired
	private DiretorRepository diretorRepository;

	@GetMapping("/admHome")
	public String escolherEditor() {

		return "Adm/admHome";
	}

	@GetMapping("/carrosselAdm")
	public String editarCarrossel() {

		return "Adm/editorCarrossel";
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

	//[COMEÇO] Diretoria

	@GetMapping("/editarDiretoria")
	public String listarDiretoria(Diretor diretor, Model model) {
		List<Diretor> diretores = diretorRepository.findAll();		
		model.addAttribute("diretores", diretores);		
		return "Adm/editorDiretoria";
	}
			
	@PostMapping("/cadastrardiretor")
	public String cadastrarDiretor(Diretor diretor){
		diretorRepository.save(diretor);
		return "redirect:/editarDiretoria";
	}
	
	@GetMapping("/removerdiretor/{id}")
	public String removerDiretor(@PathVariable(name="id") Long idDiretor){
		diretorRepository.delete(idDiretor);
		return "redirect:/editarDiretoria";
	}
	
	@GetMapping(value = "/api/diretores", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Diretor>> apiClientes(){
	
		List<Diretor> diretores = diretorRepository.findAll();
		
		return new ResponseEntity<List<Diretor>>(diretores, HttpStatus.OK);
	}

	//[FINAL] Diretoria

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
