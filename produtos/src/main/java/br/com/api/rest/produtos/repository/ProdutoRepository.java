package br.com.api.rest.produtos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.rest.produtos.model.Produtos;

@Repository
public interface ProdutoRepository extends CrudRepository<Produtos, Long> {

}
