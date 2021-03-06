package br.com.atleticaAlanTuring.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import javax.persistence.JoinColumn;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty
	private String nome;
	

	@ElementCollection
	@CollectionTable(name="pathImageProduto", joinColumns=@JoinColumn(name="id"))
	private List<String> pathImages;
	
	

	private String descricao;
	
	@NotNull
	@Max(999)
	private Integer quantidadeEstoque;
	
	@NotNull	
	private BigDecimal preco;

	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	public String getPathImage() {
		return pathImages.get(0);
	}
	
	public List<String> getPathImages(){
		return pathImages;
	}

	public void setPathImage(String pathImage) {	
		if (pathImages == null ){
			pathImages = new ArrayList<String>();	
		}
		
		this.pathImages.add(pathImage);

	}

	public boolean isValido() {
		
		return (nome.isEmpty() || descricao.isEmpty() || quantidadeEstoque == null || preco == null);
	}
	

}
