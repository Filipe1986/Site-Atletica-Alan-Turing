package br.com.atleticaAlanTuring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.atleticaAlanTuring.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
