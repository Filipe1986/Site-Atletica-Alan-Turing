package br.com.atleticaAlanTuring.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.atleticaAlanTuring.model.Categoria;
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

	@GetMapping("/admHome")
	public String escolherEditor() {

		return "Adm/admHome";
	}

	// Carrosel
	@GetMapping("/carrosselAdm")
	public String editarCarrosel(Model model) {
		return "Adm/editorCarrossel";
	}

	// Produto
	@GetMapping("/editarProdutos")
	public String listarProdutos(Produto produto, Model model) {
		List<Produto> produtos = produtoRepository.findAll();
		model.addAttribute("produtos", produtos);
		model.addAttribute("categorias", Categoria.values());
		return "Adm/editorProduto";
	}

	@PostMapping("/cadastrarprodutos")
	public String cadastrarProduto(Produto produto, Model model) {
		produtoRepository.save(produto);
		return "redirect:/editarProdutos";
	}

	@GetMapping("/cadastrarprodutos/{id}")
	public String editarProduto(Model model, @PathVariable Long id){

		Produto produto = produtoRepository.findOne(id);
		
		model.addAttribute("produtos", produto);
		model.addAttribute("categorias", Categoria.values());
		
		return "Adm/editorProduto";
	}

	@GetMapping("/removerproduto/{id}")
	public String removerProduto(@PathVariable(name = "id") Long idProduto) {
		produtoRepository.delete(idProduto);
		return "redirect:/editarProdutos";
	}

	@GetMapping(value = "/api/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Produto>> apiProdutos() {

		List<Produto> produtos = produtoRepository.findAll();

		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
	}

	// Agenda
	@GetMapping("/agendaAdm")
	public String editarAgenda() {
		return "Adm/editorAgenda";
	}

	// Diretoria
	@GetMapping("/editarDiretoria")
	public String listarDiretoria(Diretor diretor, Model model) {
		List<Diretor> diretores = diretorRepository.findAll();
		model.addAttribute("diretores", diretores);
		return "Adm/editorDiretoria";
	}
	
	@RequestMapping(value = "images/{imageName}")
	@ResponseBody
	public byte[] getImage(@PathVariable(value = "imageName") String imageName, Diretor diretor) throws IOException {

		File serverFile = new File("/resources/static/images" + imageName);

	    return Files.readAllBytes(serverFile.toPath());
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

	@PostMapping("/adicionarNovoProduto")
	public String adicionarProduto(Produto produto) {
		produtoRepository.saveAndFlush(produto);
		return "redirect:/produtoAdm";
	}

}
