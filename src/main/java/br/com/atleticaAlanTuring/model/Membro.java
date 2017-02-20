package br.com.atleticaAlanTuring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.Email;

@Entity
public class Membro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMembro;

	private String pathFotoMembro;

	private String nomeMembro;

	@ManyToMany
	private List<Equipe> equipes;

	@Column(columnDefinition = "boolean default false", nullable = false)
	private Boolean diretoria;

	@Email
	private String email;

	private String cargo;

	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	private String linkFacebook;

	public Long getIdMembro() {
		return idMembro;
	}

	public void setIdMembro(Long idMembro) {
		this.idMembro = idMembro;
	}

	public String getPathFotoMembro() {
		return pathFotoMembro;
	}

	public void setPathFotoMembro(String pathFotoMembro) {
		this.pathFotoMembro = pathFotoMembro;
	}

	public String getNomeMembro() {
		return nomeMembro;
	}

	public void setNomeMembro(String nomeMembro) {
		this.nomeMembro = nomeMembro;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public Boolean getDiretoria() {
		return diretoria;
	}

	public void setDiretoria(Boolean diretoria) {
		this.diretoria = diretoria;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getLinkFacebook() {
		return linkFacebook;
	}

	public void setLinkFacebook(String linkFacebook) {
		this.linkFacebook = linkFacebook;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

}
