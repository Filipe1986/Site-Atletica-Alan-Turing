package br.com.atleticaAlanTuring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.atleticaAlanTuring.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

}
