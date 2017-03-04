package br.com.atleticaAlanTuring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.atleticaAlanTuring.model.Grupo;
import br.com.atleticaAlanTuring.model.Permissao;

@Repository
public interface IPermissoes extends JpaRepository<Permissao, Long> {
	
	List<Permissao> findByGruposIn(Grupo grupo);

}
