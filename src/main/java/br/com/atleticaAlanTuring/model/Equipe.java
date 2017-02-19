package br.com.atleticaAlanTuring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEquipe;

	private String Modalidade;

	@ManyToMany(mappedBy = "equipes")
	private List<Membro> atletas;

	private String pathFotosEquipe;

	public Long getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(Long idEquipe) {
		this.idEquipe = idEquipe;
	}

	public String getModalidade() {
		return Modalidade;
	}

	public void setModalidade(String modalidade) {
		Modalidade = modalidade;
	}

	public List<Membro> getAtletas() {
		return atletas;
	}

	public void setAtletas(List<Membro> atletas) {
		this.atletas = atletas;
	}

	public String getPathFotosEquipe() {
		return pathFotosEquipe;
	}

	public void setPathFotosEquipe(String pathFotosEquipe) {
		this.pathFotosEquipe = pathFotosEquipe;
	}

}
