package br.com.api.rest.produtos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.rest.produtos.model.Produtos;
import br.com.api.rest.produtos.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST PRODUTOS")
@CrossOrigin(origins = "*")
public class ProdutosController {

	@Autowired
	ProdutoRepository produtoRepository;
	
	//Lista todos os produtos
	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma lista de produtos")
	public List<Produtos> listaProdutos(){
		return (List<Produtos>) produtoRepository.findAll();
	}
	
	//Lista o produto por id
	@GetMapping("/produtos/{id}")
	@ApiOperation(value = "Retorna um produto único")
	public Optional<Produtos> buscaProdutoPorId(@PathVariable(value = "id") Long id) {
		return produtoRepository.findById(id);
	}
	
	//Cadastra os produtos
	@PostMapping("/produtos")
	@ApiOperation(value = "salva o produto")
	public Produtos cadastrar(@RequestBody Produtos produtos) {
		return produtoRepository.save(produtos);
	}
	
	//Atualiza os cadastros
	@PutMapping("/produtos")
	@ApiOperation(value = "Atualiza o produto")
	public Produtos atualizaProduto(@RequestBody Produtos produtos) {
		return produtoRepository.save(produtos);
	}
	
	//Exclusão de produtos
	@DeleteMapping("/produtos/{id}")
	@ApiOperation(value = "Deleta o produto")
	public String deletaProduto(@PathVariable(value = "id") Long id) {
		produtoRepository.deleteById(id);
		return "Usuário deletado com sucesso";
	}
}
