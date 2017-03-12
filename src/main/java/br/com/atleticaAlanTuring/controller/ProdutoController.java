package br.com.atleticaAlanTuring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.atleticaAlanTuring.model.Categoria;
import br.com.atleticaAlanTuring.model.Produto;
import br.com.atleticaAlanTuring.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/editarProdutos")
	public String listarProdutos(Produto produto, Model model) {
		
		List<Produto> produtos = produtoRepository.findAll();
		model.addAttribute("produtos", produtos);
		model.addAttribute("categorias", Categoria.values());
		return "Adm/editorProduto";
	}
	
	@PostMapping("/removerproduto")
	public String removerProduto(Produto produto) {
		
		
		produtoRepository.delete(produto.getId());
		return "redirect:/editarProdutos";
	}
	
	@GetMapping(value = "/api/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Produto>> apiProdutos() {

		List<Produto> produtos = produtoRepository.findAll();

		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
	}
	
	@PostMapping("/adicionarNovoProduto")
	public String adicionarProduto(@RequestParam("file") MultipartFile file, Produto produto, Model model) {
		
		System.out.println(file.getOriginalFilename());
		String path  = "img//"+ produto.getNome()+file.getOriginalFilename();
		
		produto.setPathImage(path);
		System.out.println(file.getContentType().toString());
		
    	File arquivo = new File(path);

    	try {
			arquivo.createNewFile();
			FileOutputStream fos = null;
			fos = new FileOutputStream(arquivo);
			fos.write(file.getBytes());
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		produtoRepository.saveAndFlush(produto);
		
		return "redirect:/editarProdutos";
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
