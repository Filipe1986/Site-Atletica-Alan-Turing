package br.com.atleticaAlanTuring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	private String LinkFacebook;

}
