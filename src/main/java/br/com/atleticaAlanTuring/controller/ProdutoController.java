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

import br.com.atleticaAlanTuring.model.Categoria;
import br.com.atleticaAlanTuring.model.Produto;
import br.com.atleticaAlanTuring.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@PostMapping("/cadastrarprodutos")
	public String cadastrarProduto(Produto produto, Model model) {
		produtoRepository.save(produto);
		return "redirect:/editarProdutos";
	}
	
	@GetMapping("/editarProdutos")
	public String listarProdutos(Produto produto, Model model) {
		List<Produto> produtos = produtoRepository.findAll();
		model.addAttribute("produtos", produtos);
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
	
	@PostMapping("/adicionarNovoProduto")
	public String adicionarProduto(Produto produto) {
		produtoRepository.saveAndFlush(produto);
		return "redirect:/produtoAdm";
	}
	
	@GetMapping("/produtos/{categoria}/{id}")
	public String mostrarProduto(Model model, Produto produtos, @PathVariable(name="id") Long idProduto, @PathVariable(name="categoria") String categoriaProduto){
		
		produtos = produtoRepository.findOne(idProduto);
		model.addAttribute("produto", produtos);

		return "paginaProduto";
	}
	
	@GetMapping("/produtos")
	public String produtos(Model model) {
		List<Produto> produtos = produtoRepository.findAll();		
		model.addAttribute("produtos", produtos);
		return "produtos";
	}

}
