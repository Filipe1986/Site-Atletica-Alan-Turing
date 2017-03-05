package br.com.atleticaAlanTuring.controller;

import java.util.List;

import javax.validation.Valid;

import org.assertj.core.internal.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.com.atletica.infra.FileSaver;
import br.com.atleticaAlanTuring.model.Diretor;
import br.com.atleticaAlanTuring.model.Equipe;
import br.com.atleticaAlanTuring.model.Produto;
import br.com.atleticaAlanTuring.repository.DiretorRepository;
import br.com.atleticaAlanTuring.repository.EquipeRepository;
import br.com.atleticaAlanTuring.repository.ProdutoRepository;


@Controller
public class AdmController {


	@Autowired
	private EquipeRepository equipeRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private DiretorRepository diretorRepository;
	
	@Autowired
	private FileSaver fileSaver;

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



	@GetMapping("/institucionalAdm")
	public String editarInstitucional() {

		return "Adm/editorInstitucional";
	}

	@GetMapping("/painelAdm")
	public String editarPainel() {

		return "Adm/editorPainel";
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
	
	@PostMapping("/addNovoProduto")
	@ResponseBody
	public String gravarNovoProduto( MultipartFile sumarioPath, @Valid Produto produto, BindingResult result){

		
		String path = fileSaver.write("arquivos-sumario", sumarioPath);
		produto.setSumarioPath(path);
		produtoRepository.saveAndFlush(produto);
		return "redirect:/produtoAdm";
	}
	
	

}
