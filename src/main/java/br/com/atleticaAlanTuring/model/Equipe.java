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

}
