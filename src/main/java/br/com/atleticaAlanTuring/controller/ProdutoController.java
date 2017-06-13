package br.com.atleticaAlanTuring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.hibernate.jpa.criteria.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.tags.EditorAwareTag;

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
	
	@PostMapping("/adicionarFoto")
	public String adicionarProduto(@RequestParam("file") MultipartFile file,
			Produto produto, RedirectAttributes atributo){
		if(file.isEmpty()){
			atributo.addFlashAttribute("ERRO_ADICIONAR", "Escolha uma foto para adicionar!");
			return "redirect:/editarProdutos";
		}
		
		Produto produtoComNovaFoto = produtoRepository.getOne(produto.getId());
		String path = persistindoImagem(file,produtoComNovaFoto); 
		produtoComNovaFoto.setPathImage(path);
		atributo.addFlashAttribute("ADICIONAR", "Foto adicionada com sucesso!");
		produtoRepository.saveAndFlush(produtoComNovaFoto);
		
		
		return "redirect:/editarProdutos";
	}
	
	
	@PostMapping("/removerproduto")
	public String removerProduto(Produto produto, RedirectAttributes atributo) {
		atributo.addFlashAttribute("REMOVER", "Produto removido com sucesso!");
		produtoRepository.delete(produto.getId());
		return "redirect:/editarProdutos";
	}
	
	@GetMapping(value = "/api/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Produto>> apiProdutos() {

		List<Produto> produtos = produtoRepository.findAll();

		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
	}
	
	@PostMapping("/adicionarNovoProduto")
	public String adicionarProduto(@RequestParam("file") MultipartFile file,
			 Produto produto, Model model, RedirectAttributes atributo) {
		//validação provisória
		if (produto.isValido() || file.isEmpty()){
			System.out.println("asdfidsfds");
			List<Produto> produtos = produtoRepository.findAll();
			model.addAttribute("produtos", produtos);
			model.addAttribute("categorias", Categoria.values());
			atributo.addFlashAttribute("ERRO", "Erro: Produto não inserido!");
			
			return "redirect:/editarProdutos";
		}
		
		String path = persistindoImagem(file, produto); 
		produto.setPathImage(path);
		produtoRepository.saveAndFlush(produto);
		atributo.addFlashAttribute("SUCESSO", "Sucesso: Produto " + produto.getNome() + " inserido!");

		List<Produto> produtos = produtoRepository.findAll();
		model.addAttribute("produtos", produtos);
		model.addAttribute("categorias", Categoria.values());
		

		return "redirect:/editarProdutos";
	}

	private String persistindoImagem(MultipartFile file, Produto produto) {
		String path = "/imagens//"  +produto.getNome() + file.getOriginalFilename();
    	File arquivo = new File("src/main/resources/static" + path);

    	try {
			arquivo.createNewFile();
			FileOutputStream fos = new FileOutputStream(arquivo);
			fos.write(file.getBytes());
			fos.flush();
			fos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	
	@GetMapping("/produtos/{categoria}/{id}")
	public String mostrarProduto(Model model, Produto produtos, @PathVariable(name="id") Long idProduto, @PathVariable(name="categoria") String categoriaProduto){
		
		produtos = produtoRepository.findOne(idProduto);
		model.addAttribute("produto", produtos);
		model.addAttribute("imagens", produtos.getPathImages());

		return "paginaProduto";
	}
	
	@GetMapping("/produtos")
	public String produtos(Model model) {
		List<Produto> produtos = produtoRepository.findAll();		
		model.addAttribute("produtos", produtos);
		return "produtos";
	}

}
