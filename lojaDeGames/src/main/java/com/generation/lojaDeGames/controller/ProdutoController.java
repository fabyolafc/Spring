package com.generation.lojaDeGames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.lojaDeGames.model.ProdutoModel;
import com.generation.lojaDeGames.repository.ProdutoRepository;

@RestController
@RequestMapping("/games")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repositoty;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> GetAll(){
		return ResponseEntity.ok(repositoty.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> GetById(@PathVariable long id){
		return repositoty.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/personagem/{personagem}")
	public ResponseEntity<List<ProdutoModel>> GetByTitulo(@PathVariable String personagem){
		return ResponseEntity.ok(repositoty.findAllByPersonagemContainingIgnoreCase (personagem));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModel> post (@Valid @RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoty.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<ProdutoModel> put (@Valid @RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.OK).body(repositoty.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repositoty.deleteById(id);
	}	
}
