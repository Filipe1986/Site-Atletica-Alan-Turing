package br.com.atleticaAlanTuring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.atleticaAlanTuring.model.Diretor;
import br.com.atleticaAlanTuring.model.Produto;
import br.com.atleticaAlanTuring.repository.DiretorRepository;
import br.com.atleticaAlanTuring.repository.ProdutoRepository;

@Controller
public class VisitanteController {

	@Autowired
	private DiretorRepository diretorRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("/login")
	public String login(){
		return "login";
	}

	@GetMapping("/")
	public String index(){
		return "index";
	}

	@GetMapping("/falacomigo")
	public String contato() {
		return "contato";
	}

	//Diretoria

	@GetMapping("/diretoria")
	public String diretoria(Model model) {		
		List<Diretor> diretores = diretorRepository.findAll();		
		model.addAttribute("diretores", diretores);
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

	//Produtos

	@GetMapping("/produtos")
	public String produtos(Model model) {
		List<Produto> produtos = produtoRepository.findAll();		
		model.addAttribute("produtos", produtos);
		return "produtos";
	}

	@GetMapping("/produtos/{categoria}/{id}")
	public String mostrarProduto(Model model, Produto produtos, @PathVariable(name="id") Long idProduto, @PathVariable(name="categoria") String categoriaProduto){
		
		produtos = produtoRepository.findOne(idProduto);
		model.addAttribute("produtos", produtos);

		return "paginaProduto";
	}

	//Agenda

	@GetMapping("/agenda")
	public String agenda() {
		return "agenda";
	}	
	
}
