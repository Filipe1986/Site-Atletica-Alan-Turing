package br.com.atleticaAlanTuring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.atleticaAlanTuring.model.Diretor;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Long> {
}
