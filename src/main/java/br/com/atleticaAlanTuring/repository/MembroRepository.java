package br.com.atleticaAlanTuring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.atleticaAlanTuring.model.Membro;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

}
