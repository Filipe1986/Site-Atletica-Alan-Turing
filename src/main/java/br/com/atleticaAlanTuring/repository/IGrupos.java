package br.com.atleticaAlanTuring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.atleticaAlanTuring.model.Diretor;
import br.com.atleticaAlanTuring.model.Grupo;

@Repository
public interface IGrupos extends JpaRepository<Grupo, Long> {
	
	List<Grupo> findByDiretoresIn(Diretor diretor);

}
