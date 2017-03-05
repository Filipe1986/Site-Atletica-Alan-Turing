package br.com.atleticaAlanTuring.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEquipe;

	@Enumerated(EnumType.STRING)
	private SexoModalidade sexo;

	private String modalidade;

	private String pathFotosEquipe;

	public Long getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(Long idEquipe) {
		this.idEquipe = idEquipe;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}



	public String getPathFotosEquipe() {
		return pathFotosEquipe;
	}

	public void setPathFotosEquipe(String pathFotosEquipe) {
		this.pathFotosEquipe = pathFotosEquipe;
	}

	public SexoModalidade getSexo() {
		return sexo;
	}

	public void setSexo(SexoModalidade sexo) {
		this.sexo = sexo;
	}

}
