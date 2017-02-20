package br.com.atleticaAlanTuring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.atleticaAlanTuring.model.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

}
